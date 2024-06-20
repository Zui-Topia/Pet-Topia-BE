package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.UserRequestDTO;
import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import com.zuitopia.petopia.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.zuitopia.petopia.user.dto.UserRequestDTO;
@Service
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
    public void signUpUser(UserRequestDTO userRequestDTO) throws Exception {
        String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
////        UserVO user = new UserVO();
//        userRequestDTO.setUserEmail(userRequestDTO.getUserEmail());
        userRequestDTO.setPassword(encodedPassword);

        // 추가 필드 설정
        userMapper.insertUser(userRequestDTO);
    }

    @Override
    public void signUpPet(PetVO petVO) throws Exception {
        userMapper.insertPet(petVO);
    }

    @Override
    public UserVO loginUser(String email, String password) throws Exception {
        UserVO user = userMapper.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new Exception("Invalid email or password");
        }
    }
}
