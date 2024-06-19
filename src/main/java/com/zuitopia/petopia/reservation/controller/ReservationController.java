package com.zuitopia.petopia.reservation.controller;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;
import com.zuitopia.petopia.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@Log
@AllArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @PostMapping("/create")
    public ResponseEntity<String> reservate(@RequestBody ReservationInfoDTO reservationDTO) {
        log.info("Received reservation data: " + reservationDTO.toString());
        log.info(reservationDTO.getReservationDate().getClass().getName());

        service.createReservation(reservationDTO);

        log.info("success reservation");
        // 예약 성공 시 응답
        return ResponseEntity.ok("Reservation created successfully");

//        try {
//
//        } catch (Exception e) {
//            log.info(e.getStackTrace().toString());
//            // 예약 실패 시 응답
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create reservation");
//        }
    }
}