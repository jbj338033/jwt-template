package com.jmo.jwttemplate.global.security.jwt.error;

import com.jmo.jwttemplate.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JwtError implements CustomError {
    EXPIRED_TOKEN(401, "Expired JWT token"),
    INVALID_TOKEN(401, "Invalid JWT token"),
    UNSUPPORTED_TOKEN(401, "Unsupported JWT token"),
    MALFORMED_TOKEN(401, "Malformed JWT token"),
    INVALID_TOKEN_TYPE(401, "Invalid token type"),
    INVALID_REFRESH_TOKEN(401, "Invalid refresh token"),
    ;

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
