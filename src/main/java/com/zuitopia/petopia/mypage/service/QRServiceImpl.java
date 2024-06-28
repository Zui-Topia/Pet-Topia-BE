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

/**
 * QR service 클래스 구현체
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
@Service
@AllArgsConstructor
@Log
public class QRServiceImpl implements QRService {
    private final QRAuthMapper qrAuthMapper;

    /**
     * QR 생성하는 메소드
     * @param reservationId
     * @return int
     * @throws Exception 1. QR이 생성되지 않았습니다.
     */
    @Override
    public int generateQR(int reservationId) throws Exception {
        int create = qrAuthMapper.createQR(reservationId);
        if(create!=1)
            throw new Exception("QR이 생성되지 않았습니다");

        ReservationQRVO reservationQRVO = qrAuthMapper.getQRByReservationId(reservationId);
        return reservationQRVO.getQrId();
    }

    /**
     * QR 인증 확인하는 메소드
     * @param qrId
     * @return ReservationVO ㅇㅇㅇ
     * @throws NullPointerException QR이 만료되었거나 예약이 삭제되었습니다.
     * @throws Exception 1. 이미 사용된 예약입니다.
     *                   2. 당일에 예약된 내역이 없습니다.
     *                   3. 예약 방문한 시간이 지났습니다.
     *                   4. QR 인증에 문제가 발생했습니다. 다시 시도해보세요.
     */
    @Override
    public ReservationVO authQR(int qrId) throws Exception {
        // 만료일자가 유효한지 확인
        ReservationVO reservationVO = qrAuthMapper.getReservationByQrId(qrId);
        if(reservationVO == null)
            throw new NullPointerException("QR이 만료되었거나 예약이 삭제되었습니다.");

        // 만료된 예약인지 확인
        if(reservationVO.getReservationDelete() == 1)
            throw new Exception("이미 사용된 예약입니다.");

        // 당일 예약인지 확인
        if(!isTodayReservationDate(reservationVO.getReservationDate()))
            throw new Exception("당일에 예약된 내역이 없습니다.");

        // 예약한 시간에 대해서 최대 30분까지 인증 활성화
        if(!isReservationTimeValidate(reservationVO))
            throw new Exception("예약 방문한 시간이 지났습니다.");

        // 예약 인증 성공
        int authComplete = qrAuthMapper.updateReservationAuthComplete(reservationVO.getReservationId());

        if(authComplete==1)
            return reservationVO;
        else
            throw new Exception("QR 인증에 문제가 발생했습니다. 다시 시도해보세요.");
    }


    /**
     * 당일 날짜로 예약한 내역이 맞는지 확인하는 메소드
     * @param date
     * @return boolean
     */
    private boolean isTodayReservationDate(String date){
        // 오늘 날짜 가져오기
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDateString = dateFormat.format(today);

        log.info("isTodayReservationDate 오늘 날짜 : " + today.toString());
        // 오늘 날짜와 예약한 날짜가 같으면 당일 날짜
        if(date.equals(todayDateString))
            return true;
        return false;
    }

    /**
     * 예약 방문 시간이 유효한지 확인하는 메소드
     * @apiNote 예약 방문 시간의 30분이 지난 시간까지 예약이 유효하다고 설정
     * @param reservationVO
     * @return boolean
     */
    private boolean isReservationTimeValidate(ReservationVO reservationVO){
        try{
            // 예약한 날짜와 예약 시간에 대해서 Date값 구하기
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String reservationDate = reservationVO.getReservationDate();
            String reservationVisitTime = reservationVO.getReservationVisitTime();

            // 오전인지 오후인지 파악하기
            boolean plusHour12 =  reservationVisitTime.contains("PM") ? true : false;

            // 시간 데이터 가공하기
            String visitTimeOnly = reservationVisitTime
                    .substring(0, reservationVisitTime.length() - 2)
                    .replace(" ",""); // 마지막에서 두 번째 문자까지 잘라냄
            Date parsedDate = dateFormat.parse(reservationDate+ " " + visitTimeOnly);

            // 예약한 날짜+시간에 대해서 30분까지 예약이 유효하다고 판단
            Calendar minBefore = Calendar.getInstance();
            minBefore.setTime(parsedDate);

            // 계산된 예약한 시간에 30분 더한 값
            minBefore.add(Calendar.MINUTE, 30);

            // 오후면 12hour 더해주기
            if(plusHour12)
                minBefore.add(Calendar.HOUR, 12);

            // 계산된 예약한 시간을 Date 변수형으로 바꿔주기
            Date validateBefore30Minutes = minBefore.getTime();

            // 현재 시간 가져오기
            Date now =  new Date();
            log.info("validateBefore30Minutes : " + now.toString());
            log.info("오늘 날짜 : " + now.toString());

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
}
