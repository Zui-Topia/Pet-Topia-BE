package com.zuitopia.petopia.security;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {
    private final CustomTokenEncoder customTokenEncoder;

    public String generateToken(UserClaimDTO dto){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", dto.getUserId());
        return customTokenEncoder.createAccessToken(map);
    }
    public UserClaimDTO getClaims(String token){
        Map<String,Object> result = customTokenEncoder.extractClaims(token);

        return UserClaimDTO.builder()
                .userId((Integer)result.get("userId"))
                .build();
    }
}
