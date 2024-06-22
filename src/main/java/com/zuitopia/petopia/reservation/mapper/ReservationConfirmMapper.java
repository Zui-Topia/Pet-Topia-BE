package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationConfirmMapper {
    public Integer getStollerCount(ReservationConfirmVO reservatonConfirmVO);
    public int updateStollerCount(ReservationConfirmVO reservatonConfirmVO);
    public int insertStollerCount(ReservationConfirmVO reservationConfirmVO);
}
