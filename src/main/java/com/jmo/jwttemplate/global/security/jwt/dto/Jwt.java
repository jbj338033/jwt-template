package com.jmo.jwttemplate.global.security.jwt.dto;

public record Jwt(
        String accessToken,
        String refreshToken
) {
}