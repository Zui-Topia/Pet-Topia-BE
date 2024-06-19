package com.zuitopia.petopia.mypage.service;

import com.zuitopia.petopia.mypage.dto.MyReservationDTO;

public interface MyReservationService {
    public MyReservationDTO getMyLatestReservation(int userId); // 최신 예약 1건 가져오기

}
