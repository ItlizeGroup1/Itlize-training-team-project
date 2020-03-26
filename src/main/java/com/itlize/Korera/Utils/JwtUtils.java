package com.itlize.Korera.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    //signature
    private String key;
    //expire time
    private Long ttl;

    public JwtUtils() {
    }

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


    public String generateToken(Authentication authentication) {
        long now =  System.currentTimeMillis();
        long exp = now + ttl;
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining());
        return Jwts.builder().setSubject(authentication.getName())
                .claim("roles", authentication)
                .setExpiration(new Date(exp))
                .signWith(SignatureAlgorithm.HS256, "wenxuan liu")
                .compact();
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = resolveToken(request);
        if (token == null) {
            return null;
        }
        Claims claims = Jwts.parser().setSigningKey("wenxuan liu").parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        List<GrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
                .map(role -> role.startsWith("ROLE") ? role: "ROLE" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return username != null ? new UsernamePasswordAuthenticationToken(username, null, authorities) : null;
    }
    public boolean validaToken(HttpServletRequest request) {
        String token = resolveToken(request);
        if (token == null) {
            return false;
        }
        Claims claims = Jwts.parser().setSigningKey("wenxuan liu").parseClaimsJws(token).getBody();
        if (claims.getExpiration().before(new Date())) {
            return false;
        }
        return true;
    }
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Authorization")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
