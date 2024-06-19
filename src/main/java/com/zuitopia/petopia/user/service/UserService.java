package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.UserReactDTO;

public interface UserService {
    boolean checkEmailExists(String userEmail);
}
