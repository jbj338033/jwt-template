package com.jmo.jwttemplate.domain.user.dto.response;

import com.jmo.jwttemplate.domain.user.domain.UserRole;

public record UserResponse(
        Long id,
        String email,
        UserRole role
) {
}