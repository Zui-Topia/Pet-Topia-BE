package com.zuitopia.petopia.mypage.dto;

import com.zuitopia.petopia.dto.ReservationVO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyReservationDTO {
    private ReservationVO reservationVO;
    private PlaceDTO placeDTO;
}
