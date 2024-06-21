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

@Service
@Component
@Log
@PropertySource(value={"classpath:application.properties"})
public class CustomTokenEncoder {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expire}")
    private String ACCESS_TOKEN_EXPIRE_TIME;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String createAccessToken(Map<String, Object> payloads ){
       // SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;

        log.info("expired date : " + new Date(new Date().getTime() + Long.parseLong(ACCESS_TOKEN_EXPIRE_TIME)));
        return Jwts.builder()
                .claim("user", payloads)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + Long.parseLong(ACCESS_TOKEN_EXPIRE_TIME)))
                .signWith(this.getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

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
