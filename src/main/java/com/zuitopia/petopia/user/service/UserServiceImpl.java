package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.UserReactDTO;
import com.zuitopia.petopia.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkEmailExists(String userEmail) {
        return userMapper.checkEmailExists(userEmail) > 0;
    }
}
