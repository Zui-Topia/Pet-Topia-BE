package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationQRVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.mapper.QRAuthMapper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
public class QRServiceImpl implements QRService {
    private final QRAuthMapper qrAuthMapper;

    @Override
    public ReservationVO authQR(int qrId) throws Exception {
        // 만료일자가 유효한지 확인
        ReservationVO reservationVO = qrAuthMapper.getReservationByQrId(qrId);
        if(reservationVO == null)
            throw new Exception("만료된 QR 입니다.");

        // 만료된 예약인지 확인
        if(reservationVO.getReservationDelete() == 1)
            throw new Exception("만료된 예약입니다.");

        // 당일 예약인지 확인
        if(!isTodayReservationDate(reservationVO.getReservationDate()))
            throw new Exception("당일에 예약된 내역이 없습니다.");

        // 예약한 시간에 대해서 최대 30분까지 인증 활성화
        if(!isReservationTimeValidate(reservationVO)){
            throw new Exception("예약 방문한 시간이 지났습니다.");
        }

        // 예약 인증 성공
        int authComplete = qrAuthMapper.updateReservationAuthComplete(reservationVO.getReservationId());

        if(authComplete==1)
            return reservationVO;
        else
            throw new Exception("QR 인증에 문제가 발생했습니다. 다시 시도해보세요.");
    }

    private boolean isTodayReservationDate(String date){
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDateString = dateFormat.format(today);

        if(date.equals(todayDateString))
            return true;
        return false;
    }

    private boolean isReservationTimeValidate(ReservationVO reservationVO){
        try{
            // 예약한 날짜와 예약 시간에 대해서 Date값 구하기
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String reservationDate = reservationVO.getReservationDate();
            String reservationVisitTime = reservationVO.getReservationVisitTime();

            boolean plusHour12 =  reservationVisitTime.contains("PM") ? true : false;
            String visitTimeOnly = reservationVisitTime
                    .substring(0, reservationVisitTime.length() - 2)
                    .replace(" ",""); // 마지막에서 두 번째 문자까지 잘라냄
            Date parsedDate = dateFormat.parse(reservationDate+ " " + visitTimeOnly);

            // 예약한 날짜+시간에 대해서 30분까지 예약이 유효하다고 판단
            Calendar minBefore = Calendar.getInstance();
            minBefore.setTime(parsedDate);
            minBefore.add(Calendar.MINUTE, 30);

            // 오전, 오후 값에 따라 12hour 더해주기
            if(plusHour12)
                minBefore.add(Calendar.HOUR, 12);

            // 계산된 예약한 시간에 30분 더한 값
            Date validateBefore30Minutes = minBefore.getTime();

            // 현재 시간
            Date now = new Date();

            // 예약 시간보다 30분 더한 시간이 현재 시간보다 작은지 확인
            if(validateBefore30Minutes.before(now)) // 예약시간+30분 이 지난 경우
                return false;
            else
                return true;

        }
        catch (Exception e){
            log.info(e.getMessage());
        }
        return false;
    }

    @Override
    public int generateQR(int reservationId) throws Exception {
        int create = qrAuthMapper.createQR(reservationId);
        if(create!=1)
            throw new Exception("QR이 생성되지 않았습니다");

        ReservationQRVO reservationQRVO = qrAuthMapper.getQRByReservationId(reservationId);
        return reservationQRVO.getQrId();
    }
}
