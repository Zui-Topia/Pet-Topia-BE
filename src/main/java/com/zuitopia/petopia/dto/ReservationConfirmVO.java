package com.zuitopia.petopia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ReservationConfirmVO {
    private int branchId;
    private String reservationDate;
    private int reservationCnt;
}
