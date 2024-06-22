package com.zuitopia.petopia.mypage.controller;

import com.zuitopia.petopia.mypage.dto.DeleteRequestDTO;
import com.zuitopia.petopia.mypage.dto.MyInfoDTO;
import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.mypage.service.MyPageService;
import com.zuitopia.petopia.security.UserClaimDTO;
import com.zuitopia.petopia.security.service.TokenService;
import com.zuitopia.petopia.util.BaseResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mypage")
@AllArgsConstructor
@Log
public class MyPageController {
   private final MyPageService myPageService;
   private final TokenService tokenService;

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<BaseResponse> myPage(@RequestHeader(value = "Authorization", required = false) String token){ //@RequestParam int userId
        log.info("token 들어옴 -----------  " + token);
        UserClaimDTO claimDTO = tokenService.getClaims(token);
        log.info(claimDTO.toString());
        if(claimDTO==null)
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(false)
                            .build());
        MyInfoDTO myInfoDTO = myPageService.getMyInformation(claimDTO.getUserId());
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(myInfoDTO)
                        .build());
    }

    @ResponseBody
    @GetMapping("/history")
    public ResponseEntity<BaseResponse> reservationHistory(@RequestHeader(value = "Authorization", required = false) String token) {//@RequestParam int userId){
        UserClaimDTO claimDTO = tokenService.getClaims(token);
        log.info(claimDTO.toString());
        if(claimDTO==null)
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(false)
                            .build());

        log.info("reservationHistory " + claimDTO.getUserId());
        List<MyReservationDTO> myReservationDTOList = myPageService.getMyReservationHistory(claimDTO.getUserId());
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
