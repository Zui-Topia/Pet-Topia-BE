package com.zuitopia.petopia.reservation.controller;

import com.zuitopia.petopia.dto.ReservationConfirmVO;
import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.reservation.dto.ReservationInfoDTO;
import com.zuitopia.petopia.reservation.service.ReservationService;
import com.zuitopia.petopia.security.UserClaimDTO;
import com.zuitopia.petopia.security.service.TokenService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 예약 관련 요청을 처리하는 Controller 클래스
 * @apiNote 예약 등록, 개모차 잔여 개수 등의 기능을 제공
 * @author 정은찬
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 *  2024.06.22      최유경               리팩토링 및 header 토큰 통신 추가
 *  2024.06.21      정은찬                  개모차 잔여수 업데이트하기
 *  2024.06.20      정은찬                    개모차 잔여 개수 API
 *  2024.06.20      정은찬                       예약 등록 API
 *  2024.06.19     	정은찬        		        최초 생성
 * </pre>
 */
@RestController
@RequestMapping("/reservation")
@Log
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final TokenService tokenService;

    /**
     * 예약 등록에 대한 API
     *
     * @param token
     * @param reservationDTO
     * @return ResponseEntity<BaseResponse> 예약 등록에 대한 응답
     */
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> reservation(@RequestHeader(value = "Authorization", required = false) String token, @RequestBody ReservationInfoDTO reservationDTO) { // 예약하기
        // 유저 아이디 가져오기
        UserClaimDTO userClaimDTO = tokenService.getClaims(token);
        reservationDTO.setUserId(userClaimDTO.getUserId());
        
        // 프론트엔드단에 받은 예약 정보 저장하기
        ReservationConfirmVO reservationConfirmVO = ReservationConfirmVO.builder()
                                                            .branchId(reservationDTO.getBranchId())
                                                            .reservationDate(reservationDTO.getReservationDate())
                                                            .build();

        // 반려견 유모차 잔여 개수 가져오기
        Integer petStrollerCnt = reservationService.getStrollerCount(reservationConfirmVO);

        try{
            if ( petStrollerCnt > 0) { // 유모차 잔여 개수가 남아있을 때
                
                // 예약 등록하기
                ReservationVO reservationVO = reservationService.createReservation(reservationDTO);

                // 반려견 유모차 잔여 개수 업데이트 
                reservationService.insertOrUpdateStollerCount(petStrollerCnt, reservationConfirmVO);
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

    /**
     * 개모차 잔여 개수에 대한 API
     *
     * @param branchId
     * @param reservationDate
     * @return ResponseEntity<BaseResponse>   개모차 잔여 개수에 대한 응답
     */
    @ResponseBody
    @GetMapping("/{branchId}")
    public ResponseEntity<BaseResponse> petStrollerCnt(@PathVariable int branchId, @RequestParam String reservationDate) { // 반려견 유모차 잔여 개수 조회
        ReservationConfirmVO reservationConfirmVO = ReservationConfirmVO.builder()
                                                            .branchId(branchId)
                                                            .reservationDate(reservationDate)
                                                            .build();
    
        // 반려견 유모차 잔여 개수 가져오기
        int petStrollerCnt = reservationService.getStrollerCount(reservationConfirmVO);

        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(petStrollerCnt)
                        .build());
    }
}
