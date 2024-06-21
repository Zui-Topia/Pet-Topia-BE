package com.zuitopia.petopia.user.service;


import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SingUpRequestDTO;
import com.zuitopia.petopia.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService
{




        boolean checkEmailExists(String userEmail);
        void signUpUser(SingUpRequestDTO singUpRequestDTO) throws Exception;
        void signUpPet(PetVO petVO) throws Exception;
        LoginRequestDTO loginUser(String email, String password) throws Exception;
}


