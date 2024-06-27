package com.zuitopia.petopia.user.mapper;

import com.zuitopia.petopia.dto.UserSecurityVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 사용자 관련 데이터베이스 작업을 처리하는 매퍼 interface 개발
 * 이메일 중복 확인, 사용자 정보 삽입, 사용자 및 반려동물 정보 조회 등의 기능을 제공합니다.
 * @author jaeseong Im
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       임재성               최초 생성
 * 2024.06.21       임재성               RequestDTO 클래스 이름변경으로 인한 메서드 이름 변경
 * 2024.06.21       최유경               로그인시 토큰 발급 메서드 추가
 * </pre>
 */
@Mapper
public interface UserMapper {

    /**
     * 이메일 중복 여부를 확인하는 메소드입니다.
     *
     * @param email 확인할 이메일 주소
     * @return int 이메일 존재 여부 (1: 존재, 0: 존재하지 않음)
     * 메소드
     */
    int checkEmailExists(String email);

    /**
     * 이메일을 통해 사용자 ID를 가져오는 메소드입니다.
     *
     * @param userEmail 조회할 사용자의 이메일 주소
     * @return int 사용자의 ID
     * 메소드
     */
    int getUserIdByEmail(String userEmail);

    /**
     * 사용자 정보를 데이터베이스에 삽입하는 메소드입니다.
     *
     * @param signUpRequestDTO 회원 가입 요청 정보가 담긴 DTO
     * @return int 삽입된 행의 개수
     * 메소드
     */
    int insertUser(SignUpRequestDTO signUpRequestDTO);

    /**
     * 사용자 보안 정보를 데이터베이스에 삽입하는 메소드입니다.
     *
     * @param userSecurityVO 사용자 보안 정보가 담긴 VO
     * @return int 삽입된 행의 개수
     * 메소드
     */
    int insertUserSecurity(UserSecurityVO userSecurityVO);

    /**
     * 반려동물 정보를 데이터베이스에 삽입하는 메소드입니다.
     *
     * @param signUpRequestDTO 반려동물 정보가 담긴 DTO
     * @return int 삽입된 행의 개수
     * 메소드
     */
    int insertPet(SignUpRequestDTO signUpRequestDTO);

    /**
     * 이메일을 통해 사용자 정보를 조회하는 메소드입니다.
     *
     * @param userEmail 조회할 사용자의 이메일 주소
     * @return UserVO 조회된 사용자 정보가 담긴 VO
     * 메소드
     */
    UserVO findByEmail(String userEmail);

    /**
     * 사용자 ID를 통해 사용자 보안 정보를 조회하는 메소드입니다.
     *
     * @param userId 조회할 사용자의 ID
     * @return UserSecurityVO 조회된 사용자 보안 정보가 담긴 VO
     * 메소드
     */
    UserSecurityVO getUserSecurityByUserId(int userId);
}
