package com.example.buynow.jwt;

public interface JwtProperties {
    String SECRET = "key";
    int EXPIRATION_TIME = 3600000; // 1 hour
    String TOKEN_PREFIX = "Beaer ";
    String HEADER_STRING = "Authorization";
}
