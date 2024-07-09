package com.jmo.jwttemplate.domain.auth.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReissueRequest {
    private final String refreshToken;
}
