package com.jmo.jwttemplate.domain.auth.controller;

import com.jmo.jwttemplate.domain.auth.dto.request.LoginRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.ReissueRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.SignUpRequest;
import com.jmo.jwttemplate.domain.auth.service.AuthService;
import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;
import com.jmo.jwttemplate.global.security.jwt.dto.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest request) {
        authService.signup(request);
    }

    @PostMapping("/login")
    public Jwt login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/reissue")
    public Jwt reissue(@RequestBody ReissueRequest request) {
        return authService.reissue(request);
    }

    @GetMapping("/me")
    public UserResponse me() {
        return authService.me();
    }
}
