package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.CompletedReservationDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
<<<<<<< HEAD
    public int insert(ReservationVO reservationVO);
    public ReservationVO getCurrentInfo(ReservationVO reservationVO);
=======
    public int insert(ReservationVO reservation);

    // 개모차 잔여갯수
    public int getStrollerCount(ReservationConfirmVO reservationConfirmVO);
>>>>>>> 7d5f9f8f49e921197c035eb9b1fb26863aa29713
}
