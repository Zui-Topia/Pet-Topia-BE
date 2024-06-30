package com.zuitopia.petopia.reservation.dto;

import lombok.Data;

/**
 * 예약 정보를 담는 DTO 클래스
 * @author 정은찬
 * @since 2024.06.19
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       정은찬               예약 날짜 데이터 타입 변경
 * 2024.06.19       정은찬                      최초 생성
 * </pre>
 */
@Data
public class ReservationInfoDTO {
    private int userId;                     // 예약한 유저 아이디
    private int branchId;                   // 예약 지점 아이디
    private String reservationDate;         // 원하는 예약 날짜
    private String reservationVisitTime;    // 원하는 방문 날짜
}
