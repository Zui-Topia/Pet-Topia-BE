package com.zuitopia.petopia.dto;

import lombok.Data;

@Data
public class ReservationConfirmVO {
    private int branchId;
    private String resrvationDate;
    private int ReservationCnt;
}
