package com.zuitopia.petopia.mypage.dto;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PetSize {
    BTN_1(1, "소형견"),
    BTN_2(2, "소형견"),
    BTN_3(3, "중형견"),
    BTN_4(4, "중현견"),
    BTN_5(5, "중현견");

    private final int petSizeBtnNumber;
    private final String petSize;

    public static PetSize findByPetBtn(int btn){
        return Arrays.stream(PetSize.values())
                .filter(v->v.petSizeBtnNumber==btn)
                .findAny()
                .get();
    }


}
