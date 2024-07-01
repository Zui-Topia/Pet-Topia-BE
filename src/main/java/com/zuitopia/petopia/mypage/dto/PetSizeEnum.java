package com.zuitopia.petopia.mypage.dto;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 반려견 크기에 따른 enum 클래스
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22  	    최유경        		  petSizeBtnNumber 변경
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum PetSizeEnum {
    BTN_1(10, "소형견"),
    BTN_2(20, "소형견"),
    BTN_3(30, "중형견"),
    BTN_4(40, "중현견"),
    BTN_5(50, "중현견");

    private final int petSizeBtnNumber;
    private final String petSize;

    public static PetSizeEnum findByPetBtn(int btn){
        return Arrays.stream(PetSizeEnum.values())
                .filter(v->v.petSizeBtnNumber==btn)
                .findAny()
                .get();
    }


}
