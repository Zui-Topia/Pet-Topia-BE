package com.zuitopia.petopia.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDTO {
    private int userId;
    private String userEmail;
    private String password;
    private String petName;
    private int petWeight;
    private int petSize;
}
