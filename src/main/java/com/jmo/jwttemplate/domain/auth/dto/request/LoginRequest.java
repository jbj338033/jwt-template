package com.jmo.jwttemplate.domain.auth.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
