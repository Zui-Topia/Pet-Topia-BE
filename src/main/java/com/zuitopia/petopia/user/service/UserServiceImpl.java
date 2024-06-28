package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;

import com.zuitopia.petopia.dto.UserSecurityVO;
import com.zuitopia.petopia.security.service.TokenService;
import com.zuitopia.petopia.security.UserClaimDTO;
import com.zuitopia.petopia.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 사용자 관련 서비스 구현 클래스
 * 이메일 중복 확인, 회원 가입, 로그인 등의 기능을 제공
 *
 * @author 임재성
 * @author 최유경
 * @since 2024.06.20
 *
 * <pre>
 * 수정일             수정자                       수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22       임재성                  반려견 삽입 메서드 추가
 * 2024.06.21       최유경          회원가입 시 토큰 발급, 로그인 시 토큰 조회 추가
 * 2024.06.20       임재성                       최초 생성
 * </pre>
 */
@Service
@Log
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    /**
     * 이메일 중복 여부를 확인하는 메소드
     *
     * @param email 확인할 이메일 주소
     * @return boolean 이메일 존재 여부 (true: 존재, false: 존재하지 않음)
     *
     */
    @Override
    public boolean checkEmailExists(String email) {
        return userMapper.checkEmailExists(email) > 0;
    }

    /**
     * 사용자를 회원 가입시키고 토큰을 발급하는 메소드
     *
     * @param signUpRequestDTO 회원 가입 요청 정보가 담긴 DTO
     * @return String 발급된 토큰
     * @throws Exception 1. 유저가 생성되지 않았습니다.
     *                   2. 반려견이 생성되지 않았습니다.
     *                   3. 이메일 또는 비밀번호가 유효하지 않습니다.
     *
     */
    @Override
    @Transactional // insert 문 두 개가 모두 작동해야 회원가입 처리가 되는 것이므로 트랜잭션 처리
    public String signUpUser(SignUpRequestDTO signUpRequestDTO) throws Exception {
        try {
            // users 테이블에 새로운 유저를 생성하기
            int insertResult = userMapper.insertUser(signUpRequestDTO);

            if (insertResult < 1)
                throw new Exception("유저가 생성되지 않았습니다");

            // userId 할당받기
            int userId = userMapper.getUserIdByEmail(signUpRequestDTO.getUserEmail());
            log.info("userId : " + userId);

            // 할당받은 userId를 활용해서 password 암호화와 accessToken 발급 진행
            String encodedPassword = passwordEncoder.encode(signUpRequestDTO.getPassword());
            String accessToken = tokenService.generateToken(UserClaimDTO.builder()
                    .userId(userId)
                    .build());

            // 할당받은 userId 를 활용해서 pet 삽입 진행
            int insertPet = userMapper.insertPet(SignUpRequestDTO.builder()
                    .userId(userId)
                    .petName(signUpRequestDTO.getPetName())
                    .petWeight(signUpRequestDTO.getPetWeight())
                    .petSize(signUpRequestDTO.getPetSize())
                    .build());

            if (insertPet < 1) {
                throw new Exception("반려견이 생성되지 않았습니다.");
            }

            log.info("accessToken : " + accessToken);
            // 암호화된 비밀번호와 액세스 토큰도 데이터베이스에 별도로 저장하기
            int result = userMapper.insertUserSecurity(UserSecurityVO
                    .builder()
                    .userId(userId)
                    .password(encodedPassword)
                    .userAccessToken(accessToken)
                    .build());
            if (result == 1)
                return accessToken;
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception("이메일 또는 비밀번호가 유효하지 않습니다.");
        }
        return null;
    }

    /**
     * 사용자를 로그인시키는 메소드입니다.
     *
     * @param loginRequestDTO 로그인 요청 정보가 담긴 DTO
     * @return String 발급된 토큰
     * @throws Exception 1. 사용자가 없습니다.
     *                   2. 비밀번호가 일치하지 않습니다.
     *
     */
    @Override
    public String loginUser(LoginRequestDTO loginRequestDTO) throws Exception {
        int userId = userMapper.getUserIdByEmail(loginRequestDTO.getUserEmail());
        if (userId < 1)
            throw new Exception("사용자가 없습니다.");
        UserSecurityVO userSecurityVO = userMapper.getUserSecurityByUserId(userId);
        if (userSecurityVO != null && passwordEncoder.matches(loginRequestDTO.getPassword(), userSecurityVO.getPassword())) {
            return userSecurityVO.getUserAccessToken();
        } else {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }
    }
}
