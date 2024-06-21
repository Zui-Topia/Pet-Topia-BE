package com.zuitopia.petopia.mypage.controller;


import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
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

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
@Log
public class QRController {
    private final QRService qrService;

    @ResponseBody
    @GetMapping("/create")
    public ResponseEntity<BaseResponse> createQr(@RequestParam int reservationId){
        log.info("reservationId" + reservationId);
        try{
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

    @ResponseBody
    @GetMapping("/check")
    public ResponseEntity<BaseResponse> checkQr(@RequestParam int qrId){
        log.info("qrId" + qrId);
        try{
            qrService.authQR(qrId);
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
}
