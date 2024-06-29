package com.zuitopia.petopia.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 가입 요청 정보를 담는 DTO 클래스 개발
 * @apiNote 사용자가 회원 가입 시 입력하는 사용자 정보와 반려동물 정보를 포함
 *
 * @author 임재성
 * @since 2024.06.20
 *
 * <pre>
 * 수정일             수정자                       수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22       임재성           반려견 정보 변수 생성 및 @Builder 어노테이션 생성
 * 2024.06.21       임재성                     클래스 이름 변경
 * 2024.06.20       임재성                       최초 생성
 * </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {
    private int userId;             // 사용자의 고유 ID
    private String userEmail;       // 사용자의 이메일 주소
    private String password;        // 사용자의 비밀번호
    private String petName;         // 반려동물의 이름
    private int petWeight;          // 반려동물의 몸무게
    private int petSize;            // 반려동물의 체고
}
