package com.jmo.jwttemplate.domain.auth.service;

import com.jmo.jwttemplate.domain.auth.dto.request.LoginRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.ReissueRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.SignUpRequest;
import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;
import com.jmo.jwttemplate.global.security.jwt.dto.Jwt;

public interface AuthService {
    void signup(SignUpRequest request);

    Jwt login(LoginRequest request);

    Jwt reissue(ReissueRequest request);

    UserResponse me();
}
