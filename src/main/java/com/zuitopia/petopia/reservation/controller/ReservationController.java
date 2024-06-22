package com.zuitopia.petopia.reservation.controller;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;
import com.zuitopia.petopia.reservation.service.ReservationService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@Log
@AllArgsConstructor
public class ReservationController {

    private final ReservationService service;
    
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> reservation(@RequestBody ReservationInfoDTO reservationDTO) { // 예약하기
        log.info("들어옴 : " + reservationDTO.toString());
        ReservationConfirmVO reservationConfirmVO = new ReservationConfirmVO(
                                                        reservationDTO.getBranchId(),
                                                        reservationDTO.getReservationDate());

        // 반려견 유모차 잔여 개수 가져오기
        Integer petStrollerCnt = service.getStrollerCount(reservationConfirmVO);
        log.info("cnt----  " + petStrollerCnt);

        try{
            if ( petStrollerCnt > 0) { // 유모차 잔여 개수가 남아있을 때
                
                // 예약 등록하기
                ReservationVO reservationVO = service.createReservation(reservationDTO);
                log.info(reservationVO.toString());
                // 반려견 유모차 잔여 개수 업데이트 
                service.insertOrUpdateStollerCount(petStrollerCnt, reservationConfirmVO);
                return ResponseEntity
                        .ok()
                        .body(BaseResponse.builder()
                                .success(true)
                                .data(reservationVO)
                                .build());
            }
            else{ // 유모차 잔여 개수가 없을 때
                throw new Exception("잔여 개수가 없습니다");
            }
        }
        catch (Exception e){
            log.info(e.getMessage());
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(e.getMessage())
                            .build());
        }
    }

    @ResponseBody
    @GetMapping("/{branchId}")
    public ResponseEntity<BaseResponse> petStrollerCnt(@PathVariable int branchId, @RequestParam String reservationDate) { // 반려견 유모차 잔여 개수 조회
        ReservationConfirmVO reservationConfirmVO = new ReservationConfirmVO();
        reservationConfirmVO.setBranchId(branchId);
        reservationConfirmVO.setReservationDate(reservationDate);
    
        // 반려견 유모차 잔여 개수 가져오기
        int petStrollerCnt = service.getStrollerCount(reservationConfirmVO);

        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(petStrollerCnt)
                        .build());
    }
}
