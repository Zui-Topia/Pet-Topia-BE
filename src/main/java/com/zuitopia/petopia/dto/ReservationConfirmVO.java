package com.zuitopia.petopia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationConfirmVO {
    private int branchId;
    private String reservationDate;
    private int reservationCnt;

    public ReservationConfirmVO(int branchId, String reservationDate){
        this.branchId = branchId;
        this.reservationDate = reservationDate;
    }

}
