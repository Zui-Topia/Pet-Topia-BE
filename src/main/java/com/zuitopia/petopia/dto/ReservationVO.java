package com.zuitopia.petopia.dto;

import java.util.Date;
import lombok.Data;

@Data
public class ReservationVO {
    private int reservationId;
    private int userId; // 예약한 유저 아이디
    private int branchId; // 예약 지점 아이디
    private String reservationToken; // 예약 번호
    private String reservationDate; // 원하는 예약 날짜
    private String reservationVisitTime; // 원하는 방문 날짜
    private Date reservationCreateDate; //예약 생성 날짜
    private int reservationPayment;
    private int reservationDelete; // 예약 삭제 여부
}
