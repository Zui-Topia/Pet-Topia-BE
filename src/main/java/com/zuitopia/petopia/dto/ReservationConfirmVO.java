package com.zuitopia.petopia.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 개모차 잔여 개수 정보를 담는 VO
 * @author Eunchan Jeong
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       최유경                     Builder 어노테이션 추가
 * 2024.06.19       정은찬                     최초 생성
 * </pre>
 */
@Data
@Builder
public class ReservationConfirmVO {
    private int branchId;    // 지점 ID
    private String reservationDate; // 예약 날짜
    private int reservationCnt; // 개모차 잔여 개수
}
