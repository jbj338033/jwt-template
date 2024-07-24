package com.jmo.jwttemplate.domain.auth.dto.request;

public record ReissueRequest(
        String refreshToken
) {
}