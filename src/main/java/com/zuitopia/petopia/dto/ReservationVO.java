package com.zuitopia.petopia.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 예약 정보를 담는 VO
 * @author Eunchan Jeong
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       최유경                     예약 생성 날짜 데이터타입 변경
 * 2024.06.19       최유경                      최초 생성
 * </pre>
 */
@Data
@Builder
public class ReservationVO {
    private int reservationId; // 예약 아이디
    private int userId; // 예약한 유저 아이디
    private int branchId; // 예약 지점 아이디
    private String reservationToken; // 예약 번호
    private String reservationDate; // 원하는 예약 날짜
    private String reservationVisitTime; // 원하는 방문 날짜
    private Date reservationCreateDate; //예약 생성 날짜
    private int reservationPayment; // 결제 여부
    private int reservationDelete; // 예약 삭제 여부
    private Date reservationDeleteDate; // 예약 삭제 날짜
}
