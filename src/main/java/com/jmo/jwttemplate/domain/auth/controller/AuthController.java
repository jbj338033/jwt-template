package com.jmo.jwttemplate.domain.auth.controller;

import com.jmo.jwttemplate.domain.auth.dto.request.LoginRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.ReissueRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.SignUpRequest;
import com.jmo.jwttemplate.domain.auth.service.AuthService;
import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;
import com.jmo.jwttemplate.global.common.BaseResponse;
import com.jmo.jwttemplate.global.security.jwt.dto.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse<Void>> signup(@RequestBody SignUpRequest request) {
        authService.signup(request);

        return BaseResponse.of(null, 201);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<Jwt>> login(@RequestBody LoginRequest request) {
        return BaseResponse.of(authService.login(request), 201);
    }

    @PostMapping("/reissue")
    public ResponseEntity<BaseResponse<Jwt>> reissue(@RequestBody ReissueRequest request) {
        return BaseResponse.of(authService.reissue(request), 201);
    }
}
