package com.zuitopia.petopia.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class LoginRequestDTO {


    private String userEmail;

    private String password;

    // Getters and Setters
}
