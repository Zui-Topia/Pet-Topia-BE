package com.zuitopia.petopia.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class UserSecurityVO {
    private int userId;
    private String password;
    private String userAccessToken;
}
