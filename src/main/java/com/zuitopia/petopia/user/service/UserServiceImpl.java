package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.LoginRequestDTO;
import com.zuitopia.petopia.user.dto.SingUpRequestDTO;

import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;

import com.zuitopia.petopia.user.mapper.UserMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean checkEmailExists(String userEmail) {

        return userMapper.checkEmailExists(userEmail) > 0;
    }

    @Override
    public void signUpUser(SingUpRequestDTO singUpRequestDTO) throws Exception {
        String encodedPassword = passwordEncoder.encode(singUpRequestDTO.getPassword());
////        UserVO user = new UserVO();
//        userRequestDTO.setUserEmail(userRequestDTO.getUserEmail());
        singUpRequestDTO.setPassword(encodedPassword);

        // 추가 필드 설정
        userMapper.insertUser(singUpRequestDTO);
    }

    @Override
    public void signUpPet(PetVO petVO) throws Exception {
        userMapper.insertPet(petVO);
    }

    @Override
    public LoginRequestDTO loginUser(String userEmail, String password) throws Exception {
        UserVO user = userMapper.findByEmail(userEmail);
        log.info("패스워드~~~~~~~~~~~~~~~~~~~~~~~"+ password);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            LoginRequestDTO loginRequestDTO = new LoginRequestDTO();

            loginRequestDTO.setUserEmail(user.getUserEmail());

//            responseDTO.setUserAccessToken("dummy_access_token"); // 이 부분은 실제로 구현해야 함

            return loginRequestDTO;
        } else {
            throw new Exception("Invalid email or password");
        }
    }


}
