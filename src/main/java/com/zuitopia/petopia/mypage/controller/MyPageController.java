package com.zuitopia.petopia.mypage.controller;

import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.service.MyReservationService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mypage")
@AllArgsConstructor
@Log
public class MyPageController {
    private MyReservationService myReservationService;

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<BaseResponse> myPage(@RequestParam Long userId){
        log.info("myPage " + userId);
        MyReservationDTO myReservationDTO = myReservationService.getMyLatestReservation(userId);

        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(myReservationDTO)
                        .build());
    }
}
