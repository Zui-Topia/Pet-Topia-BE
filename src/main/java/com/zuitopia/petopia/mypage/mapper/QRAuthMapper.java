package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.dto.ReservationQRVO;
import com.zuitopia.petopia.dto.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * QR 관련 interface 개발
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
     * QR insert 하는 메소드
     * @param reservationId
     * @return int
     */
    public int createQR(int reservationId);

    /**
     * QR update 하는 메소드
     * @param reservationId
     * @return int
     */
    public int updateReservationAuthComplete(int reservationId);

    /**
     * 예약 아이디값으로 QR 조회하는 메소드
     * @param reservationId
     * @return ReservationQRVO
     */
    public ReservationQRVO getQRByReservationId(int reservationId);

    /**
     * QR 아이디값으로 예약 조회하는 메소드
     * @param qrId
     * @return ReservationVO
     */
    public ReservationVO getReservationByQrId(int qrId);

}
