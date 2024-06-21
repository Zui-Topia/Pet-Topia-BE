package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationQRVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.mapper.QRAuthMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QRServiceImpl implements QRService {
    private final QRAuthMapper qrAuthMapper;

    @Override
    public ReservationVO authQR(int qrId) throws Exception {

        // 만료일자가 유효한지 확인
        ReservationVO reservationVO = qrAuthMapper.getReservationByQrId(qrId);
        if(reservationVO == null)
            throw new Exception("만료된 QR 입니다. 재발급 받아주세요.");

        // 만료된 예약인지 확인
        if(reservationVO.getReservationDelete() == 1)
            throw new Exception("만료된 예약입니다.");

        // 당일 예약인지 확인
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDateString = dateFormat.format(today);

        if(!reservationVO.getReservationDate().equals(todayDateString))
            throw new Exception("당일에 예약된 내역이 없습니다.");

        return reservationVO;
    }

    @Override
    public int generateQR(int reservationId) throws Exception {
//        ReservationQRVO reservationQRVO = ReservationQRVO.builder()
//                .reservationId(reservationId)
//                .qrExpireTime(new Date(new Date().getTime() + 30))
//                .build();
        int create = qrAuthMapper.createQR(reservationId);
        if(create!=1)
            throw new Exception("QR이 생성되지 않았습니다");

        ReservationQRVO reservationQRVO = qrAuthMapper.getQRByReservationId(reservationId);
        return reservationQRVO.getQrId();
    }
}
