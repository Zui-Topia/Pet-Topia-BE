package com.zuitopia.petopia.reservation.service;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;

public interface ReservationService {
    public int createReservation(ReservationInfoDTO reservationDTO);

    public int getStrollerCount(ReservationConfirmVO reservationConfirmVO);
}
