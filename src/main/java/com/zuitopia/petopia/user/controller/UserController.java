package com.zuitopia.petopia.user.controller;

import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.UserRequestDTO;
import com.zuitopia.petopia.user.service.UserService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Log
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/check")
    public ResponseEntity<BaseResponse> checkEmailExists(@RequestParam String email) {
        boolean exists = userService.checkEmailExists(email);
        log.info("Email check request for: " + email + " - Exists: " + exists);
        return exists ? // 이메일이 존재하면 error
                ResponseEntity
                        .ok()
                        .body(BaseResponse.builder()
                                .success(false)
                                .data(exists)
                                .build())
                : // 이메일 존재 안하니까 회원가입 가능
                ResponseEntity
                        .ok()
                        .body(BaseResponse.builder()
                                .success(true)
                                .data(exists)
                                .build());
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<BaseResponse> signUpUser(@RequestBody UserRequestDTO userRequestDTO) {
        log.info("userRequestDTO: " + userRequestDTO.toString());
        try {
            userService.signUpUser(userRequestDTO);
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(true) // 필요에 따라 데이터 설정
                            .build());
        } catch (Exception e) {
            log.info("Error occurred during user sign up");
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(false)
                            .build());
        }
    }


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<BaseResponse> loginUser(@RequestBody UserRequestDTO userRequestDTO ) { // }, HttpSession session) {
        log.info("Login request for: " + userRequestDTO.getUserEmail());
        try {
            String accessToken = userService.loginUser(userRequestDTO);
//            session.setAttribute("user", user);
            return ResponseEntity
                    .ok()
                    .header("Authorization", accessToken)
                    .body(BaseResponse.builder()
                        .success(true)
                        .data(true)
                        .build());
        } catch (Exception e) {
            log.info("로그인 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                    .success(false)
                    .data(false)
                    .build());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<BaseResponse> logoutUser(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().body(BaseResponse.builder()
                .success(true)
                .data(true)
                .build());
    }
}