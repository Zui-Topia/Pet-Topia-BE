package com.zuitopia.petopia.user.controller;

import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SingUpRequestDTO;
import com.zuitopia.petopia.user.service.UserService;
import com.zuitopia.petopia.util.BaseResponse;
import com.zuitopia.petopia.util.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<BaseResponse> signUpUser(@RequestBody SingUpRequestDTO singUpRequestDTO) {
        log.info("userRequestDTO: " + singUpRequestDTO.toString());
        try {
            userService.signUpUser(singUpRequestDTO);
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
    public ResponseEntity<BaseResponse> loginUser(@RequestBody LoginRequestDTO requestDTO, HttpServletRequest request) {
        log.info("로그인 기록: " + requestDTO.toString());
        try {
            log.info("트라이들어옴");
            LoginRequestDTO user = userService.loginUser(requestDTO.getUserEmail(), requestDTO.getPassword());

          HttpSession session = request.getSession(true); // 세션이 없으면 새로 생성
           session.setAttribute("user", user.getUserEmail()); // 세션에 로그인 사용자 정보 저장
            return ResponseEntity
                    .ok()
//                     .header(session.getAttribute("user"))
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(user.getUserEmail())
                            .build());
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(e.getMessage())
                            .build());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 현재 세션 가져오기 (없으면 null 반환)
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        return ResponseEntity.ok("Logged out successfully");
//        return ResponseEntity.ok(BaseResponse.builder().success(true).data("Logged out successfully").build());
    }


    @GetMapping("/session")
    @ResponseBody
    public ResponseEntity<BaseResponse> getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userEmail = (String) session.getAttribute("user");
            if (userEmail != null) {
                return ResponseEntity.ok(BaseResponse.builder().success(true).data(userEmail).build());
            }
        }
        return ResponseEntity.ok(BaseResponse.builder().success(false).data(null).build());
    }
}
