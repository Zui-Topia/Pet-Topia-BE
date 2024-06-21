package com.zuitopia.petopia.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserClaimDTO {
    private int userId;
}
