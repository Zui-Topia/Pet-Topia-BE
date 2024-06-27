package com.zuitopia.petopia.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 가입 요청 정보를 담는 DTO 클래스 개발
 * 사용자가 회원 가입 시 입력하는 사용자 정보와 반려동물 정보를 포함합니다.
 * @author jaeseong Im
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       임재성              최초 생성
 * 2024.06.21       임재성              클래스 이름 변경
 * 2024.06.22       임재성              반려견 정보 변수 생성 및 @Builder 어노테이션 생성
 * </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {

    /**
     * 사용자의 고유 ID를 나타냅니다.
     */
    private int userId;

    /**
     * 사용자의 이메일 주소를 나타냅니다.
     */
    private String userEmail;

    /**
     * 사용자의 비밀번호를 나타냅니다.
     */
    private String password;

    /**
     * 반려동물의 이름을 나타냅니다.
     */
    private String petName;

    /**
     * 반려동물의 몸무게를 나타냅니다.
     */
    private int petWeight;

    /**
     * 반려동물의 크기를 나타냅니다.
     */
    private int petSize;
}
