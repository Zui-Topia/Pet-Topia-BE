package com.zuitopia.petopia.reservation.mapper;

import com.zuitopia.petopia.dto.ReservationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    public void insert(ReservationVO reservation);
}
