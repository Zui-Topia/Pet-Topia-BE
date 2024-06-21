package com.zuitopia.petopia.user.service;


import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.UserRequestDTO;


public interface UserService
{
        boolean checkEmailExists(String userEmail);
        String signUpUser(UserRequestDTO userRequestDTO) throws Exception; // 토큰 발급하기
        void signUpPet(PetVO petVO) throws Exception;
        String loginUser(UserRequestDTO userRequestDTO) throws Exception; // 로그인 메서드 추가
}


