package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.UserReactVO;
import com.zuitopia.petopia.user.mapper.UserMapper;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public int getTotalUsers(UserReactVO userReactVO) {


        return userMapper.getUserEmail();
    }

}
