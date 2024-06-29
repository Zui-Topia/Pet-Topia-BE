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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 마이페이지 Controller
 *
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.22       최유경           예약 전체 내역 조회 API, 예약 삭제 API 추가
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Controller
@RequestMapping("/mypage")
@AllArgsConstructor
@Log
public class MyPageController {
   private final MyPageService myPageService;
   private final TokenService tokenService;

    /**
     * 마이페이지 첫 페이지 API
     * @param token
     * @return ResponseEntity<BaseResponse> 1. 사용자 정보
     *                                      2. 반려견 정보
     *                                      3. 최근 예약 1건
     */
    @ResponseBody
    @GetMapping("")
    public ResponseEntity<BaseResponse> myPage(@RequestHeader(value = "Authorization", required = false) String token){
        log.info("[myPage] -----------  ");
        try{
            UserClaimDTO claimDTO = tokenService.getClaims(token);
            log.info(claimDTO.toString());

            MyInfoDTO myInfoDTO = myPageService.getMyInformation(claimDTO.getUserId());
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(myInfoDTO)
                            .build());
        }
        catch (NullPointerException e){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(e.getMessage())
                            .build());
        }
    }

    /**
     * 전체 예약 내역 조회 API
     * @param token
     * @return ResponseEntity<BaseResponse> List 로 전체 예약 내역 조회
     */
    @ResponseBody
    @GetMapping("/history")
    public ResponseEntity<BaseResponse> reservationHistory(@RequestHeader(value = "Authorization", required = false) String token) {
        log.info("[reservationHistory] -----------  ");
        try{
            UserClaimDTO claimDTO = tokenService.getClaims(token);
            log.info(claimDTO.toString());

            List<MyReservationDTO> myReservationDTOList = myPageService.getMyReservationHistory(claimDTO.getUserId());
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(myReservationDTOList)
                            .build());
        }
        catch (NullPointerException e){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(e.getMessage())
                            .build());
        }
    }

    /**
     * 예약 삭제하는 API
     * @param deleteRequestDTO
     * @return ResponseEntity<BaseResponse> 예약 삭제 여부 boolean으로 전달
     */
    @ResponseBody
    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> deleteMyReservation(@RequestBody DeleteRequestDTO deleteRequestDTO){
        log.info("[deleteMyReservation] -----------  ");
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
