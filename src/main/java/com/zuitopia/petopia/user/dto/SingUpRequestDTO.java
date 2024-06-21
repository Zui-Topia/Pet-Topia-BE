package com.zuitopia.petopia.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class SingUpRequestDTO {
    private String userEmail;
    private String password;



}
