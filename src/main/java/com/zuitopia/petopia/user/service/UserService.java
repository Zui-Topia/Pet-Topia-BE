package com.zuitopia.petopia.user.service;

import com.zuitopia.petopia.user.dto.UserReactDTO;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean checkEmailExists(String userEmail);
}
