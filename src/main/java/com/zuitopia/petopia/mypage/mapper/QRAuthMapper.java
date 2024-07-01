package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.dto.ReservationQRVO;
import com.zuitopia.petopia.dto.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * QR 관련 Mapper interface
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
@Mapper
public interface QRAuthMapper {
    /**
     * QR insert 하는 메서드
     * @param reservationId
     * @return int
     */
    int createQR(int reservationId);

    /**
     * QR update 하는 메서드
     * @param reservationId
     * @return int
     */
    int updateReservationAuthComplete(int reservationId);

    /**
     * 예약 아이디값으로 QR 조회하는 메서드
     * @param reservationId
     * @return ReservationQRVO
     */
    ReservationQRVO getQRByReservationId(int reservationId);

    /**
     * QR 아이디값으로 예약 조회하는 메서드
     * @param qrId
     * @return ReservationVO
     */
    ReservationVO getReservationByQrId(int qrId);

}
