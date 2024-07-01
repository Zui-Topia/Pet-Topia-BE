package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;

/**
 * 사용자 관련 서비스 interface 개발
 * @apiNote 이메일 중복 확인, 회원 가입, 로그인 등의 기능을 제공
 * @author 임재성
 * @since 2024.06.20
 *
 * <pre>
 * 수정일            수정자                        수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21       임재성        RequestDTO 클래스 이름 변경으로 인한 파라미터 이름 변경
 * 2024.06.20       임재성                       최초 생성
 * </pre>
 */
public interface UserService {
    /**
    * 이메일 중복 여부를 확인하는 메서드
    * @param email 확인할 이메일 주소
    * @return boolean 이메일 존재 여부 (true: 존재, false: 존재하지 않음)
    *
    */
    boolean checkEmailExists(String email);

    /**
    * 사용자를 회원 가입시키고 토큰을 발급하는 메서드
    * @param signUpRequestDTO 회원 가입 요청 정보가 담긴 DTO
    * @return String 발급된 토큰
    * @throws Exception 회원 가입 중 발생할 수 있는 예외
    *
    */
    String signUpUser(SignUpRequestDTO signUpRequestDTO) throws Exception;

    /**
    * 사용자를 로그인시키는 메서드
    * @param loginRequestDTO 로그인 요청 정보가 담긴 DTO
    * @return String 발급된 토큰
    * @throws Exception 로그인 중 발생할 수 있는 예외
    *
    */
    String loginUser(LoginRequestDTO loginRequestDTO) throws Exception;
}
