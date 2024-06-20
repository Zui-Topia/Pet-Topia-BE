package com.zuitopia.petopia.dto;

import lombok.Data;

@Data
public class ReservationConfirmVO {
    private int branchId;
    private String reservationDate;
    private int ReservationCnt;
}
