package com.zuitopia.petopia.user.service;


import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SignUpRequestDTO;


public interface UserService
{
        boolean checkEmailExists(String email);
        String signUpUser(SignUpRequestDTO signUpRequestDTO) throws Exception; // 토큰 발급하기
        void signUpPet(PetVO petVO) throws Exception;
        String loginUser(LoginRequestDTO loginRequestDTO) throws Exception; // 로그인 메서드 추가
}


