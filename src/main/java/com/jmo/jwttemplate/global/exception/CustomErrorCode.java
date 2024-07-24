package com.jmo.jwttemplate.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode {
    // JWT
    EXPIRED_JWT_TOKEN(401, "Expired JWT token"),
    INVALID_JWT_TOKEN(401, "Invalid JWT token"),
    UNSUPPORTED_JWT_TOKEN(401, "Unsupported JWT token"),
    MALFORMED_JWT_TOKEN(401, "Malformed JWT token"),
    INVALID_TOKEN_TYPE(401, "Invalid token type"),
    INVALID_REFRESH_TOKEN(401, "Invalid refresh token"),

    // AUTH
    EMAIL_DUPLICATION(400, "Email is already in use"),
    USER_NOT_FOUND(400, "User not found"),
    WRONG_PASSWORD(400, "Wrong password"),
    ;

    private final int status;
    private final String message;
}
