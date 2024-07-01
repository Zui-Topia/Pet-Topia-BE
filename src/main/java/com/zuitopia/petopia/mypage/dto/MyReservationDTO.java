package com.zuitopia.petopia.mypage.dto;

import com.zuitopia.petopia.dto.ReservationVO;
import lombok.Builder;
import lombok.Data;

/**
 * 마이페이지 화면에 보여줄 나의 예약 정보
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22  	    최유경        		        최초 생성
 * </pre>
 */
@Data
@Builder
public class MyReservationDTO {
    private ReservationVO reservationVO;    // 예약 상세 내용
    private PlaceDTO placeDTO;              // 예약 위치 정보
}
