package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.CompletedReservationDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    public int insert(ReservationVO reservationVO);
    public ReservationVO getCurrentInfo(ReservationVO reservationVO);
}
