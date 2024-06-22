package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import java.util.List;

public interface MyPageService {
    public MyInfoDTO getMyInformation(int userId);
    public MyReservationDTO getMyLatestReservation(int userId); // 최신 예약 1건 가져오기

    public List<MyReservationDTO> getMyReservationHistory(int userId); // 과거 예약 내역 가져오기
    public int deleteMyReservation(int reservationId) throws Exception;
}
