package com.zuitopia.petopia.reservation.dto;

import lombok.Data;

@Data
public class CompletedReservationDTO {
    private String reservationToken; // 예약 번호
    private String reservationDate; // 원하는 예약 날짜
    private String reservationVisitTime; // 원하는 방문 날짜

}
