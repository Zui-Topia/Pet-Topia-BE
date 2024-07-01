package com.zuitopia.petopia.mypage.dto;

import lombok.Data;

/**
 * 마이페이지 화면에 보여줄 반려견 정보
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22  	    최유경        		        최초 생성
 * </pre>
 */
@Data
public class MyPagePetDTO {
    private int petId;              // 반려견 ID
    private String petName;         // 반려견 이름
    private int petWeight;          // 반려견 몸무게
    private int petSize;            // 반려견 사이즈
    private String petSizeString;   // 반려견 (소형견, 중형견, 대형견 구분)
}
