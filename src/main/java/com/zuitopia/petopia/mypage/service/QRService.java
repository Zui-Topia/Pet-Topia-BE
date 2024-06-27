package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationVO;

/**
 * QR interface 개발
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
public interface QRService {
    /**
     * QR 인증 확인하는 메소드
     * @param qrId
     * @return ReservationVO
     * @throws Exception QR 인증 실패
     */
    public ReservationVO authQR(int qrId) throws Exception;

    /**
     * QR 생성하는 메소드
     * @param reservationId
     * @return int
     * @throws Exception QR이 생성 실패
     */
    public int generateQR(int reservationId) throws Exception;

}
