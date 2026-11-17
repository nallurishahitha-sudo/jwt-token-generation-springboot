package com.klu.jwtgeneration;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey key;

    public JwtService(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    public String generateToken(Map<String, Object> payload) {
        long now = System.currentTimeMillis();

        return Jwts.builder()
                .claims(payload)
                .issuedAt(new Date(now))
                .expiration(new Date(now + 60 * 60 * 1000))
                .signWith(key)
                .compact();
    }
}
