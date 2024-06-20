package com.zuitopia.petopia.dto;

import lombok.Data;

@Data
public class PetVO {
    private int petId;
    private String petName;
    private int petWeight;
    private int petSize;
    private int userId;
}
