package com.zuitopia.petopia.sample.controller;

import com.zuitopia.petopia.dto.SampleVO;
//import com.zuitopia.petopia.mypage.dto.MyReservationDTO;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@NoArgsConstructor
@Log
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<BaseResponse> get(@RequestParam Long userId) {
        log.info("get 들어옴" + userId);
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data("완료")
                        .build());
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<BaseResponse> post(@RequestBody SampleVO sampleVO) {
        log.info("post 들어옴" + sampleVO.toString());
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(sampleVO)
                        .build());
    }
}
