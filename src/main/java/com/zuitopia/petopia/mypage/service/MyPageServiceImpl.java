package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
import com.zuitopia.petopia.mypage.dto.MyPagePetDTO;
import com.zuitopia.petopia.mypage.dto.MyPageUserDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.dto.PetSize;
import com.zuitopia.petopia.mypage.dto.PlaceDTO;
import com.zuitopia.petopia.mypage.mapper.MyPageInformationMapper;
import com.zuitopia.petopia.mypage.mapper.MyReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyPageServiceImpl implements MyPageService {
    private final MyPageInformationMapper myPageInformationMapper;
    private final MyReservationMapper myReservationMapper;

    @Override
    public MyInfoDTO getMyInformation(int userId) {
        // 사용자 정보 가져오기
        MyPageUserDTO myPageUserDTO = myPageInformationMapper.getMyPageUserDTO(userId);

        // 반려견 정보 가져오기
        MyPagePetDTO myPagePetDTO = myPageInformationMapper.getMyPagePetDTO(userId);
        myPagePetDTO.setPetSizeString(PetSize
                .findByPetBtn(myPagePetDTO.getPetSize())
                .getPetSize());

        return MyInfoDTO.builder()
                .myPageUserDTO(myPageUserDTO)
                .myPagePetDTO(myPagePetDTO)
                .myReservationDTO(getMyLatestReservation(userId))
                .build();
    }

    @Override
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
