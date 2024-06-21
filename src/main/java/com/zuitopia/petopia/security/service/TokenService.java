package com.zuitopia.petopia.security.service;

import com.zuitopia.petopia.security.UserClaimDTO;

public interface TokenService {
    public String generateToken(UserClaimDTO dto);
    public UserClaimDTO getClaims(String token);
}
