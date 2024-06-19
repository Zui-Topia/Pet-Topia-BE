package com.zuitopia.petopia.reservation.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationInfoDTO {
    private int userId; // 예약한 유저 아이디
    private int branchId; // 예약 지점 아이디
    private Date reservationDate; // 원하는 예약 날짜
    private String reservationVisitTime; // 원하는 방문 날짜
}
