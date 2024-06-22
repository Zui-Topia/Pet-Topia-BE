package com.zuitopia.petopia.mypage.dto;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
