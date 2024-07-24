package com.jmo.jwttemplate.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 8, max = 32)
        String password
) {
}