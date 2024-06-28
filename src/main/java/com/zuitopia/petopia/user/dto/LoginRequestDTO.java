package com.zuitopia.petopia.user.dto;

import lombok.Data;

/**
 * 로그인 요청 정보를 담는 DTO 클래스 개발
 * @apiNote 사용자가 로그인 시 입력하는 이메일과 비밀번호 정보를 포함
 *
 * @author 임재성
 * @since 2024.06.20
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21       임재성                     클래스 이름 변경
 * 2024.06.20       임재성                      최초 생성
 * </pre>
 */
@Data
public class LoginRequestDTO {
    private String userEmail;    // 사용자가 입력한 이메일 주소
    private String password;     // 사용자가 입력한 비밀번호

}
