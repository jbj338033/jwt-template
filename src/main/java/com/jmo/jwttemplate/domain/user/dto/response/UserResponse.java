package com.jmo.jwttemplate.domain.user.dto.response;

import com.jmo.jwttemplate.domain.user.domain.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private final Long id;
    private final String email;
    private final UserRole role;
}
