package com.zuitopia.petopia.reservation.controller;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.CompletedReservationDTO;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;
import com.zuitopia.petopia.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuitopia.petopia.util.BaseResponse;

@RestController
@RequestMapping("/reservation")
@Log
@AllArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> reservate(@RequestBody ReservationInfoDTO reservationDTO) {
        log.info("Received reservation data: " + reservationDTO.toString());
        log.info(reservationDTO.getReservationDate().getClass().getName());


        int isInserted = service.createReservation(reservationDTO);

        if(isInserted == 1) {
            log.info("Success reservation");

            CompletedReservationDTO completedReservationDTO = service.getCurrenctReservationInfo(reservationDTO);
            log.info(completedReservationDTO.toString());

            log.info("Success get info");
            // 예약 성공 시 응답
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(completedReservationDTO)
                            .build());
        }
        else {
            log.info("Failed to create reservation");
            CompletedReservationDTO currentVO = service.getCurrenctReservationInfo(reservationDTO);
            // 예약 실패 시 응답
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(currentVO)
                            .build());

        }
    }
}