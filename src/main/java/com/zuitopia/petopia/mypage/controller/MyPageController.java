package com.zuitopia.petopia.mypage.controller;

import com.zuitopia.petopia.mypage.dto.DeleteRequestDTO;
import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.service.MyPageService;
import com.zuitopia.petopia.util.BaseResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mypage")
@AllArgsConstructor
@Log
public class MyPageController {
   private final MyPageService myPageService;

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<BaseResponse> myPage(@RequestParam int userId){
        log.info("myPage " + userId);
        MyInfoDTO myInfoDTO = myPageService.getMyInformation(userId);
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(myInfoDTO)
                        .build());
    }

    @ResponseBody
    @GetMapping("/history")
    public ResponseEntity<BaseResponse> reservationHistory(@RequestParam int userId){
        log.info("reservationHistory " + userId);
        List<MyReservationDTO> myReservationDTOList = myPageService.getMyReservationHistory(userId);
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(myReservationDTOList)
                        .build());
    }


    @ResponseBody
    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> deleteMyReservation(@RequestBody DeleteRequestDTO deleteRequestDTO){
        log.info("deleteMyReservation " + deleteRequestDTO.getReservationId());
        try{
            int result = myPageService.deleteMyReservation(deleteRequestDTO.getReservationId());
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(result)
                            .build());
        }
        catch (Exception e){
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(e.getMessage())
                            .build());
        }

    }
}
