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

/**
 * 사용자 관련 요청을 처리하는 Controller 클래스 개발
 * 회원 가입, 로그인, 이메일 중복 확인 등의 기능을 제공합니다.
 *
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21       최유경               로그인 시 토큰 발급 로직 추가
 * 2024.06.21       임재성               RequestDTO 클래스 이름변경으로 인한 메서드 이름 변경, 로그인 로직 추가
 * 2024.06.20       임재성               최초 생성
 * </pre>
 */
@Controller
@Log
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 이메일 중복 확인 API
     *
     * @param email 확인할 이메일 주소
     * @return ResponseEntity<BaseResponse> 이메일 중복 여부에 대한 응답
     * 메소드
     */
    @GetMapping("/check")
    public ResponseEntity<BaseResponse> checkEmailExists(@RequestParam String email) {
        boolean exists = userService.checkEmailExists(email);
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

    /**
     * 사용자 회원 가입 API
     *
     * @param signUpRequestDTO 회원 가입 요청 정보가 담긴 DTO
     * @return ResponseEntity<BaseResponse> 회원 가입 처리 결과 응답
     * @throws Exception 회원 가입 중 발생할 수 있는 예외
     * 메소드
     */
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<BaseResponse> signUpUser(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        try {
            userService.signUpUser(signUpRequestDTO);
            return ResponseEntity
                    .ok()
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(true) // 필요에 따라 데이터 설정
                            .build());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(false)
                            .build());
        }
    }

    /**
     * 사용자 로그인 API
     *
     * @param loginRequestDTO 로그인 요청 정보가 담긴 DTO
     * @return ResponseEntity<BaseResponse> 로그인 처리 결과 응답
     * @throws Exception 로그인 중 발생할 수 있는 예외
     * 메소드
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<BaseResponse> loginUser(@RequestBody LoginRequestDTO loginRequestDTO ) {
        try {
            String accessToken = userService.loginUser(loginRequestDTO);
            return ResponseEntity
                    .ok()
                    .header("Authorization", accessToken)
                    .body(BaseResponse.builder()
                            .success(true)
                            .data(true)
                            .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.builder()
                            .success(false)
                            .data(false)
                            .build());
        }
    }
}
