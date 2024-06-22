package com.zuitopia.petopia.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SignUpRequestDTO {
    private String userEmail;
    private String password;



}
