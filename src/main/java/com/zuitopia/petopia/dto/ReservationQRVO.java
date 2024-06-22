package com.zuitopia.petopia.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationQRVO {
    private int qrId;
    private int reservationId;
    private Date qrExpireTime;
}
