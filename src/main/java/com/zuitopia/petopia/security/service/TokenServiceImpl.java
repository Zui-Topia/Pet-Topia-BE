package com.zuitopia.petopia.security.service;

import com.zuitopia.petopia.security.UserClaimDTO;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * TokenService 구현체
 * @author 최유경
 * @since 2024.06.21
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21  	    최유경        		        최초 생성
 * </pre>
 */
@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final CustomTokenEncoder customTokenEncoder;

    /**
     * @param dto
     * @return String
     */
    @Override
    public String generateToken(UserClaimDTO dto){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", dto.getUserId());
        return customTokenEncoder.createAccessToken(map);
    }

    /**
     * @param token
     * @return UserClaimDTO
     * @throws NullPointerException 1. 해당 userId 값이 존재하지 않습니다.
     */
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
