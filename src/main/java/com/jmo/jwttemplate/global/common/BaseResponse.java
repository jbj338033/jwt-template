package com.jmo.jwttemplate.global.common;

import org.springframework.http.ResponseEntity;

public record BaseResponse<T>(
        T data,
        int status,
        String message
) {
    public static <T> ResponseEntity<BaseResponse<T>> of(T data) {
        return BaseResponse.of(data, 200, "");
    }

    public static <T> ResponseEntity<BaseResponse<T>> of(T data, int status) {
        return BaseResponse.of(data, status, "");
    }

    public static <T> ResponseEntity<BaseResponse<T>> of(T data, int status, String message) {
        return ResponseEntity.status(status).body(new BaseResponse<>(data, status, message));
    }
}
