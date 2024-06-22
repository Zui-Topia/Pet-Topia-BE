package com.zuitopia.petopia.user.controller;

import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;
import com.zuitopia.petopia.user.service.UserService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/check")
    public ResponseEntity<BaseResponse> checkEmailExists(@RequestParam String email) {
        log.info("check들어옴:");
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
    public ResponseEntity<BaseResponse> signUpUser(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        log.info("signUpRequestDTO: " + signUpRequestDTO.toString());
        try {
            userService.signUpUser(signUpRequestDTO);
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
    public ResponseEntity<BaseResponse> loginUser(@RequestBody LoginRequestDTO loginRequestDTO ) { // }, HttpSession session) {
        log.info("Login request for: " + loginRequestDTO.getUserEmail());
        try {
            //아이디는 맞는데 비밀번호가 틀렸을 경우 처리 필요함
            log.info("로그인들어옴1");
            String accessToken = userService.loginUser(loginRequestDTO);
            log.info("로그인들어옴2");
//            session.setAttribute("user", user);
            return ResponseEntity
                    .ok()
                    .header("Authorization", "Bearer " + accessToken)
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
}
