package com.jmo.jwttemplate.global.error;

import lombok.Builder;
import org.springframework.http.ResponseEntity;

@Builder
public record ErrorResponse(int status, String message) {
    public static ResponseEntity<ErrorResponse> of(CustomError error) {
        return ResponseEntity.status(error.getStatus()).body(ErrorResponse.builder()
                .status(error.getStatus())
                .message(error.getMessage())
                .build());
    }
}
