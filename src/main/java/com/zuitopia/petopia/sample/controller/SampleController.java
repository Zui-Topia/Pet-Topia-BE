package com.zuitopia.petopia.sample.controller;

import com.zuitopia.petopia.dto.SampleVO;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@NoArgsConstructor
@Log
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<String> get() {
        log.info("get 들어옴");
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<String> post(@RequestBody SampleVO sampleVO) {
        log.info(sampleVO.toString());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
