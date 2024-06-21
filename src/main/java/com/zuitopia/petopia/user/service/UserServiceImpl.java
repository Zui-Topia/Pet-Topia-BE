package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;

import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserSecurityVO;
import com.zuitopia.petopia.security.service.TokenService;
import com.zuitopia.petopia.security.UserClaimDTO;
import com.zuitopia.petopia.user.mapper.UserMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean checkEmailExists(String userEmail) {

        return userMapper.checkEmailExists(userEmail) > 0;
    }

    @Override
    @Transactional // insert 문 두 개가 모두 작동해야 회원가입 처리가 되는 것이므로 트랜잭션 처리
    public String signUpUser(SignUpRequestDTO signUpRequestDTO) throws Exception {
        try{
            // users 테이블에 새로운 유저를 생성하기
            int insertResult = userMapper.insertUser(signUpRequestDTO);

            if(insertResult < 1)
                throw new Exception("유저가 생성되지 않았습니다");

            // userId 할당받기
            int userId = userMapper.getUserIdByEmail(signUpRequestDTO.getUserEmail());
            log.info("userId : " + userId);

            // 할당받은 userId를 활용해서 password 암호화와 accessToken 발급 진행
            String encodedPassword = passwordEncoder.encode(signUpRequestDTO.getPassword());
            String accessToken = tokenService.generateToken(UserClaimDTO.builder()
                    .userId(userId)
                    .build());

            log.info("accessToken : " + accessToken);
            // 암호화된 비밀번호화 액세스 토큰도 데이터베이스에 별도로 저장하기
            int result = userMapper.insertUserSecurity(UserSecurityVO   //usersecurityVo를 어디서받아?
                    .builder()
                    .userId(userId)
                    .password(encodedPassword)
                    .userAccessToken(accessToken)
                    .build());
            if(result==1)
             return accessToken; //이 return  값을 리액트에 뿌려야하는건가?
        }
        catch (Exception e){
            log.info(e.getMessage());
            throw new Exception("Invalid email or password");
        }
        return null;
    }

    @Override
    public void signUpPet(PetVO petVO) throws Exception {
        userMapper.insertPet(petVO);
    }

    @Override
    public String loginUser(LoginRequestDTO loginRequestDTO) throws Exception {
        int userId = userMapper.getUserIdByEmail(loginRequestDTO.getUserEmail());
        if(userId < 1)
            throw new Exception("사용자가 없습니다.");

        UserSecurityVO userSecurityVO = userMapper.getUserSecurityByUserId(userId);
        if (userSecurityVO != null && passwordEncoder.matches(loginRequestDTO.getPassword(), userSecurityVO.getPassword())) {
            return userSecurityVO.getUserAccessToken();   // 이 리턴을 어떻게?
        } else {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }
    }


}
