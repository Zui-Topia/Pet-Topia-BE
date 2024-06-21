package com.zuitopia.petopia.mypage.dto;

import lombok.Data;

@Data
public class MyPagePetDTO {
    private int petId;
    private String petName;
    private int petWeight;
    private int petSize;
    private String petSizeString;
}
