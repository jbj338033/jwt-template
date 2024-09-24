package com.jmo.jwttemplate.domain.user.service;

import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;

public interface UserService {
    UserResponse getMe();
}
