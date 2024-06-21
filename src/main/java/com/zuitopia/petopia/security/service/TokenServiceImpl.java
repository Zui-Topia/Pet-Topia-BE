package com.zuitopia.petopia.security.service;

import com.zuitopia.petopia.security.UserClaimDTO;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final CustomTokenEncoder customTokenEncoder;

    @Override
    public String generateToken(UserClaimDTO dto){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", dto.getUserId());
        return customTokenEncoder.createAccessToken(map);
    }
    @Override
    public UserClaimDTO getClaims(String token){
        Map<String,Object> result = customTokenEncoder.extractClaims(token);

        return UserClaimDTO.builder()
                .userId((Integer)result.get("userId"))
                .build();
    }
}
