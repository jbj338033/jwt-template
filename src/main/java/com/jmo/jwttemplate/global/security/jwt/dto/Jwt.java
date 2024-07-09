package com.jmo.jwttemplate.global.security.jwt.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class Jwt {
    private final String accessToken;
    private final String refreshToken;
}
