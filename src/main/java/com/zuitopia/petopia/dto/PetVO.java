package com.zuitopia.petopia.dto;

import lombok.Data;

/**
 * 반려동물 정보를 담는 VO 클래스
 * @author 임재성
 * @since 2024.06.20
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       임재성                      최초 생성
 * </pre>
 */
@Data
public class PetVO {
    private int petId;      // 반려동물의 고유 ID
    private String petName; // 반려동물의 이름
    private int petWeight;  // 반려동물의 몸무게
    private int petSize;    // 반려동물의 크기
    private int userId;     // 반려동물 소유자의 사용자 ID
}
