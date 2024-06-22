package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
import com.zuitopia.petopia.mypage.dto.MyPagePetDTO;
import com.zuitopia.petopia.mypage.dto.MyPageUserDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.dto.PetSizeEnum;
import com.zuitopia.petopia.mypage.dto.PlaceDTO;
import com.zuitopia.petopia.mypage.mapper.MyPageInformationMapper;
import com.zuitopia.petopia.mypage.mapper.MyReservationMapper;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
public class MyPageServiceImpl implements MyPageService {
    private final MyPageInformationMapper myPageInformationMapper;
    private final MyReservationMapper myReservationMapper;

    @Override
    public MyInfoDTO getMyInformation(int userId) {
        // 사용자 정보 가져오기
        MyPageUserDTO myPageUserDTO = myPageInformationMapper.getMyPageUserDTO(userId);

        // 반려견 정보 가져오기
        MyPagePetDTO myPagePetDTO = myPageInformationMapper.getMyPagePetDTO(userId);
        myPagePetDTO.setPetSizeString(PetSizeEnum
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
        try{
            // 사용자의 최신 예약 1건 가져오기
            ReservationVO reservationVO = myReservationMapper.getReservationVO(userId);
            if(reservationVO==null)
                return null;

            // 날짜 가공하기
            String reservationDate = reservationVO.getReservationDate();
            reservationVO.setReservationDate(convertToDateFormat(reservationDate));

            // 시간 가공하기
            String reservationVisitTime = reservationVO.getReservationVisitTime();
            reservationVO.setReservationVisitTime(convertToTimeFormat(reservationVisitTime));

            // 해당 예약에 대해서 반려견 유모차 정보 가져오기
            PlaceDTO placeDTO = myReservationMapper.getReservationPlaceInfo(reservationVO.getBranchId());

            return MyReservationDTO.builder()
                    .reservationVO(reservationVO)
                    .placeDTO(placeDTO)
                    .build();
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
        return null;
    }
    @Override
    public List<MyReservationDTO> getMyReservationHistory(int userId) {
        List<MyReservationDTO> myReservationDTOList = new ArrayList<>();
        try{
            // 사용자의 최신 예약 1건 가져오기
            List<ReservationVO> reservationVOList = myReservationMapper.getReservationVOList(userId);

            for(ReservationVO vo : reservationVOList){
                // 날짜 가공하기
                String reservationDate = vo.getReservationDate();
                vo.setReservationDate(convertToDateFormat(reservationDate));

                // 시간 가공하기
                String reservationVisitTime = vo.getReservationVisitTime();
                vo.setReservationVisitTime(convertToTimeFormat(reservationVisitTime));

                // 해당 예약에 대해서 반려견 유모차 정보 가져오기
                PlaceDTO placeDTO = myReservationMapper.getReservationPlaceInfo(vo.getBranchId());

                myReservationDTOList.add(MyReservationDTO.builder()
                                            .reservationVO(vo)
                                            .placeDTO(placeDTO)
                                            .build());
            }
            return myReservationDTOList;
        }
        catch (Exception e){
            log.info(e.getMessage());
        }
        return myReservationDTOList;
    }

    @Override
    public int deleteMyReservation(int reservationId) {
        return 0;
    }

    private String convertToDateFormat(String reservationDate){
        StringBuilder dateSb = new StringBuilder();
        dateSb.append(reservationDate.replace("-",".")); //yyyy-mm-dd 형식
        dateSb.append(" ");
        dateSb.append(StringWeekday(reservationDate));
        return dateSb.toString();
    }

    private String convertToTimeFormat(String reservationVisitTime){
        String visitTimeOnly = reservationVisitTime
                .substring(0, reservationVisitTime.length() - 2); // 마지막에서 두 번째 문자까지 잘라냄
        StringBuilder timeSb = new StringBuilder();
        timeSb.append(reservationVisitTime.contains("AM") ? "오전" : "오후");
        timeSb.append(" ");
        timeSb.append(visitTimeOnly);
        return timeSb.toString();
    }


    private String StringWeekday(String date){
        LocalDate localDate = LocalDate.parse(date);

        String week = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
        return week;
    }
}
