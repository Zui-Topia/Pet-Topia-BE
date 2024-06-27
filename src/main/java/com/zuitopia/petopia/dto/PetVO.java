package com.zuitopia.petopia.dto;

import lombok.Data;

/**
 * 반려동물 정보를 담는 VO 클래스 개발
 * 반려동물 ID, 이름, 몸무게, 크기, 소유자 ID 등의 정보를 포함합니다.
 * @author jaeseong Im
 *
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20      임재성               최초 생성
 * </pre>
 */
@Data
public class PetVO {

    /**
     * 반려동물의 고유 ID를 나타냅니다.
     */
    private int petId;

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

    /**
     * 반려동물 소유자의 사용자 ID를 나타냅니다.
     */
    private int userId;
}
