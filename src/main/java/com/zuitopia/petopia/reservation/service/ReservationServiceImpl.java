package com.zuitopia.petopia.reservation.service;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.CompletedReservationDTO;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;
import com.zuitopia.petopia.reservation.mapper.ReservationMapper;

import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper mapper;
    @Override
    public int createReservation(ReservationInfoDTO reservationInfoDTO) { // 에약정보를 예약DB에 저장
        // 개모차가 남아있는지 확인한 후 예약 진행 여부 판단 (잔여개수 확인)
        
        // 1. ReservationVO 생성 및 ReservationDTO 정보 받아오기
        ReservationVO reservationVO = new ReservationVO();

        reservationVO.setUserId(reservationInfoDTO.getUserId());

        reservationVO.setBranchId(reservationInfoDTO.getBranchId());

        reservationVO.setReservationDate(reservationInfoDTO.getReservationDate());
        reservationVO.setReservationVisitTime(reservationInfoDTO.getReservationVisitTime());
        
        // 2. reservationToken 생성
        Random random = new Random();

        // 두자리수 난수
        int randomNumber = random.nextInt(90) + 10;
        String randomString = String.valueOf(randomNumber);

        // 현재 시간 여섯자리수
        LocalTime currentTime = LocalTime.now();
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HHmmss"));

        // 예약 아이디
        String reservationToken = randomString + formattedTime + reservationInfoDTO.getUserId();

        reservationVO.setReservationToken(reservationToken);

        // 3. 예약정보 저장하기
        int isInserted = mapper.insert(reservationVO);

        return isInserted;
    }
    @Override
    public CompletedReservationDTO getCurrenctReservationInfo(ReservationInfoDTO reservationInfoDTO) { // 현재 예약한 정보 가져오기
        log.info("getCurrenctReservationInfo start!!!!!!!!!!");
        // 1. ReservationVO 생성 및 ReservationDTO 정보 받아오기
        ReservationVO reservationVO = new ReservationVO();

        reservationVO.setUserId(reservationInfoDTO.getUserId());

        reservationVO.setBranchId(reservationInfoDTO.getBranchId());

        reservationVO.setReservationDate(reservationInfoDTO.getReservationDate());
        reservationVO.setReservationVisitTime(reservationInfoDTO.getReservationVisitTime());

        ReservationVO currentInfoVO = mapper.getCurrentInfo(reservationVO);

        CompletedReservationDTO completedReservationDTO = new CompletedReservationDTO();
        completedReservationDTO.setReservationToken(currentInfoVO.getReservationToken());
        completedReservationDTO.setReservationDate(currentInfoVO.getReservationDate());
        completedReservationDTO.setReservationVisitTime(currentInfoVO.getReservationVisitTime());

        return completedReservationDTO;
        
    }
}
