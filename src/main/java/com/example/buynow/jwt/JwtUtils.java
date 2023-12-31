package com.example.buynow.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.buynow.user.entity.User;

import java.util.Date;

import static com.example.buynow.jwt.JwtProperties.*;

public class JwtUtils {
    // 토큰에서 원하는 정보 추출
    public static String getClaim(String jwtToken, String claim){
        return JWT.require(Algorithm.HMAC512(SECRET))
                .build()
                .verify(jwtToken)
                .getClaim(claim)
                .asString();
    }

    // 토큰 생성
    public static String createJwtToken(User user){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .withClaim("username", user.getId())
                .sign(Algorithm.HMAC512(SECRET));
    }

    // 전처리 삭제
    public static String removePrefix(String jwtHeader) { return jwtHeader.replace(TOKEN_PREFIX, ""); }
}
