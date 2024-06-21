package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationVO;

public interface QRService {
    public ReservationVO authQR(int qrId) throws Exception;

    public int generateQR(int reservationId) throws Exception;

}
