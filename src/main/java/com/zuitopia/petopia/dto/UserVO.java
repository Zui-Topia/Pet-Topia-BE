package com.zuitopia.petopia.dto;

import lombok.Data;

import java.util.Date;

/**
 * 사용자 정보를 담는 VO 클래스 개발
 * 사용자 ID, 이메일, 비밀번호, 액세스 토큰, 가입 날짜, 가입 방법 등의 정보를 포함합니다.
 * @author jaeseong Im
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       임재성               최초 생성
 * </pre>
 */
@Data
public class UserVO {

    /**
     * 사용자의 고유 ID를 나타냅니다.
     */
    private int userId;

    /**
     * 사용자의 비밀번호를 나타냅니다.
     */
    private String password;

    /**
     * 사용자의 이메일 주소를 나타냅니다.
     */
    private String userEmail;

    /**
     * 사용자의 액세스 토큰을 나타냅니다.
     */
    private String userAccessToken;

    /**
     * 사용자의 가입 날짜를 나타냅니다.
     */
    private Date joinDate;

    /**
     * 사용자의 가입 방법을 나타냅니다.
     * 예: 1 - 일반 가입, 2 - 소셜 로그인 등
     */
    private int joinMethod; // 가입 방법

}
