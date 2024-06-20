package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.dto.PlaceDTO;
import com.zuitopia.petopia.mypage.mapper.MyReservationMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log
@AllArgsConstructor
public class MyReservationServiceImpl implements MyReservationService {
    private final MyReservationMapper myReservationMapper;
    @Override
    @Transactional
    public MyReservationDTO getMyLatestReservation(int userId) {
        // 사용자의 최신 예약 1건 가져오기
        ReservationVO reservationVO = myReservationMapper.getReservationVO(userId);

        // 해당 예약에 대해서 반려견 유모차 정보 가져오기
        PlaceDTO placeDTO = myReservationMapper.getReservationPlaceInfo(reservationVO.getBranchId());

        return MyReservationDTO.builder()
                .reservationVO(reservationVO)
                .placeDTO(placeDTO)
                .build();
    }

}
