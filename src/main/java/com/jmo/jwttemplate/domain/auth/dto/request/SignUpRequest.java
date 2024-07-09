package com.jmo.jwttemplate.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpRequest {
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Size(min = 8, max = 32)
    private final String password;
}
