package com.zuitopia.petopia.reservation.service;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.CompletedReservationDTO;

import com.zuitopia.petopia.dto.ReservationConfirmVO;

import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;

public interface ReservationService {
    // 예약하기
    public ReservationVO createReservation(ReservationInfoDTO reservationDTO) throws Exception;

    // 유모차 잔여수 가져오기
    public Integer getStrollerCount(ReservationConfirmVO reservationConfirmVO);
    
    // 유모차 잔여수 업데이트
    public int insertOrUpdateStollerCount(Integer strollerCnt, ReservationConfirmVO reservationConfirmVO) throws Exception;

}
