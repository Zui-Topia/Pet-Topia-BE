package com.zuitopia.petopia.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * CustomTokenEncoder 클래스
 * @apiNote JWT를 활용해서 사용자 accessToken 발급
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
@Component
@Log
@PropertySource(value={"classpath:application.properties"})
public class CustomTokenEncoder {

    @Value("${jwt.secret}")
    private String SECRET_KEY; // jwt 암호화 시 필요한 secret key

    @Value("${jwt.expire}")
    private String ACCESS_TOKEN_EXPIRE_TIME; // accessToken 만료 시간

    /**
     * BASE64로 key 생성하는 메서드
     * @return SecretKey
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * JWT를 활용해서 accessToken 생성하는 메서드
     * @apiNote 만료시간 30일로 지정
     * @param payloads
     * @return String
     */
    public String createAccessToken(Map<String, Object> payloads ){
        return Jwts.builder()
                .claim("user", payloads)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + Long.parseLong(ACCESS_TOKEN_EXPIRE_TIME)))
                .signWith(this.getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Claims 값을 추출하는 메서드
     * @param token
     * @return Map<String,Object>
     */
    public Map<String,Object> extractClaims(String token){
        return (Map<String,Object>)
                Jwts.parser()
                .verifyWith(this.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("user");
    }
}
