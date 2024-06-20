package com.zuitopia.petopia.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
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

        return Jwts.builder()
                .claim("user", payloads)
                .issuedAt(new Date())
                .expiration(new Date(new Date() + ACCESS_TOKEN_EXPIRE_TIME))
                .signWith(this.getSigningKey())
                .compact();
    }

    public Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(this.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
