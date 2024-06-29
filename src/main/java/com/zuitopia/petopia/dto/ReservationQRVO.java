package com.zuitopia.petopia.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * 예약 QR 정보를 담는 ReservationQRVO
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
@Data
@Builder
public class ReservationQRVO {
    private int qrId;           // qr ID
    private int reservationId;  // 예약 ID
    private Date qrExpireTime;  // qr 만료시간
}
