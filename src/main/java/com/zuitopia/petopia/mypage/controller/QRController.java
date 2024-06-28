package com.zuitopia.petopia.mypage.controller;


import com.zuitopia.petopia.dto.ReservationVO;
import com.zuitopia.petopia.mypage.service.QRService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 마이페이지 QR 관련 Controller
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22       최유경           예약 전체 내역 조회 API, 예약 삭제 API 추가
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Controller
@RequestMapping("/auth")
@AllArgsConstructor
@Log
public class QRController {
    private final QRService qrService;

    /**
     * QR 생성하는 API
     * @param reservationId
     * @return ResponseEntity<BaseResponse> qrId 값을 반환
     */
    @ResponseBody
    @GetMapping("/create")
    public ResponseEntity<BaseResponse> createQr(@RequestParam int reservationId){
        log.info("reservationId" + reservationId);
        try{
            // 새로운 QR 생성하기
            int qrId = qrService.generateQR(reservationId);
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(qrId)
                            .build());
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
     * QR 인증을 확인하는 API
     * @apiNote 1. 인증 성공 시, 예약 정보 전달
     *          2. 인증 실패 시, 오류 메시지 전달
     * @param qrId
     * @return ResponseEntity<BaseResponse> 예약 정보 전달
     */
    @ResponseBody
    @GetMapping("/check")
    public ResponseEntity<BaseResponse> checkQr(@RequestParam int qrId){
        log.info("qrId" + qrId);
        try{
            // QR로 예약 정보 확인하기
            ReservationVO reservationVO = qrService.authQR(qrId);
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(reservationVO)
                            .build());
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
}
