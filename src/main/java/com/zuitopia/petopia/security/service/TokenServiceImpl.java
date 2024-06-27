package com.zuitopia.petopia.security.service;

import com.zuitopia.petopia.security.UserClaimDTO;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.apache.ibatis.jdbc.Null;
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
    public UserClaimDTO getClaims(String token) throws NullPointerException {
        Map<String,Object> result = customTokenEncoder.extractClaims(token);

        if(result.get("userId")==null)
            throw new NullPointerException("해당 userId 값이 존재하지 않습니다.");

        return UserClaimDTO.builder()
                .userId((Integer)result.get("userId"))
                .build();
    }
}
