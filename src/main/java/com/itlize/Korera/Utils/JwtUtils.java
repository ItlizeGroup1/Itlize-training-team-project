package com.itlize.Korera.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtils {
    //signature
    private String key;
    //expire time
    private Long ttl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    /**
     * Setting        UserDetail
     *
     */
    public String createJwtToken(String username, Map<String, Object> map) {
        // 1. Set expire time
        long now =  System.currentTimeMillis();
        long exp = now + ttl;
        // 2. Create JwtBuilder
        JwtBuilder builder = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key)
                .setClaims(map)
                .setExpiration(new Date(exp));

        String token = builder.compact();
        return token;
    }

    /**
     * Get claims through parsing token
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createJwtToken(userDetails.getUsername(), claims);
    }



    public Boolean validToken(String token, UserDetails userDetails) {
        final String username = parseJwt(token).getSubject();
        return username.equals(userDetails.getUsername()) && isTokenExpire(token);

    }

    public Boolean isTokenExpire(String token) {
        return parseJwt(token).getExpiration().before(new Date());
    }

}
