package com.zuitopia.petopia.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserRequestDTO {
    private String userEmail;
    private String password;
    private String petName;
    private String userAccessToken;
}
