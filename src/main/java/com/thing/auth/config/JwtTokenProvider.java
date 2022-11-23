package com.thing.auth.config;

import com.thing.auth.type.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@NoArgsConstructor
public class JwtTokenProvider {

    private long tokenValidMillisecond;
    private Key key;

    public JwtTokenProvider(String secretKey, long tokenValidMillisecond){
        this.tokenValidMillisecond = tokenValidMillisecond;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(Integer clientIndex, Role role){
        Claims claims = Jwts.claims().setSubject(String.valueOf(clientIndex));
        claims.put("role", role);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰 검증
    public boolean validateToken(String token){
        try {
            Claims claims = this.getTokenClaims(token).getBody();
            if(claims == null) return false;
            return claims.getExpiration().after(new Date());
        }catch(Exception e) {
            log.info("옳바르지 않은 JWT 토큰입니다.");
            return false;
        }
    }

    // 토큰 속성 정보 추출
    private Jws<Claims> getTokenClaims(String token){
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
        } catch (SecurityException e) {
            log.info("JWT 서명이 옳바르지 않습니다.");
        } catch (MalformedJwtException e) {
            log.info("JWT 토큰이 옳바르지 않습니다.");
        } catch (ExpiredJwtException e) {
            log.info("JWT 토큰이 만료되었습니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰 압축이 옳바르지 않습니다.");
            e.printStackTrace();
        }
        return null;
    }
}
