package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    public int insert(ReservationVO reservation);

    // 개모차 잔여갯수
    public int getStrollerCount(ReservationConfirmVO reservationConfirmVO);
}
