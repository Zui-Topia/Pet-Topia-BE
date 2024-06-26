package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationVO;

/**
 * QR 서비스 interface
 * @apiNote QR을 생성하고 인증하는 기능 제공
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
     * QR 인증 확인하는 메서드
     * @param qrId
     * @return ReservationVO
     * @throws Exception QR 인증 실패
     */
    ReservationVO authQR(int qrId) throws Exception;

    /**
     * QR 생성하는 메서드
     * @param reservationId
     * @return int
     * @throws Exception QR이 생성 실패
     */
    int generateQR(int reservationId) throws Exception;

}
