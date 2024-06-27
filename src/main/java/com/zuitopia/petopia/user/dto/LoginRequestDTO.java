package com.zuitopia.petopia.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 로그인 요청 정보를 담는 DTO 클래스 개발
 * 사용자가 로그인 시 입력하는 이메일과 비밀번호 정보를 포함합니다.
 * @author jaeseong Im
 *
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       임재성               최초 생성
 * 2024.06.21       임재성               클래스 이름 변경
 * </pre>
 */
@Data
public class LoginRequestDTO {

    /**
     * 사용자의 입력한 이메일 주소를 나타냅니다.
     */
    private String userEmail;

    /**
     * 사용자의 입력한 비밀번호를 나타냅니다.
     */
    private String password;

}
