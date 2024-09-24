package com.jmo.jwttemplate.domain.user.controller;

import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;
import com.jmo.jwttemplate.domain.user.service.UserService;
import com.jmo.jwttemplate.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<BaseResponse<UserResponse>> getMe() {
        return BaseResponse.of(userService.getMe());
    }
}
