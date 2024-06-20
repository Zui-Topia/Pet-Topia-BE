package com.zuitopia.petopia.user.service;


import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.UserRequestDTO;


public interface UserService
{




        boolean checkEmailExists(String userEmail);
        void signUpUser(UserRequestDTO userRequestDTO) throws Exception;
        void signUpPet(PetVO petVO) throws Exception;
        UserVO loginUser(String userEmail, String password) throws Exception; // 로그인 메서드 추가
}


