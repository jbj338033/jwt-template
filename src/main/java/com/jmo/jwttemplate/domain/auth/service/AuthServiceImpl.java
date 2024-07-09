package com.jmo.jwttemplate.domain.auth.service;

import com.jmo.jwttemplate.domain.auth.dto.request.LoginRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.ReissueRequest;
import com.jmo.jwttemplate.domain.auth.dto.request.SignUpRequest;
import com.jmo.jwttemplate.domain.user.domain.User;
import com.jmo.jwttemplate.domain.user.domain.UserRole;
import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;
import com.jmo.jwttemplate.domain.user.repository.UserRepository;
import com.jmo.jwttemplate.global.exception.CustomErrorCode;
import com.jmo.jwttemplate.global.exception.CustomException;
import com.jmo.jwttemplate.global.security.jwt.JwtProvider;
import com.jmo.jwttemplate.global.security.jwt.dto.Jwt;
import com.jmo.jwttemplate.global.security.jwt.enums.JwtType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public void signup(SignUpRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        if (userRepository.existsByEmail(email)) throw new CustomException(CustomErrorCode.EMAIL_DUPLICATION);

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Jwt login(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new CustomException(CustomErrorCode.WRONG_PASSWORD);

        return jwtProvider.generateToken(email, user.getRole());
    }

    @Override
    public Jwt reissue(ReissueRequest request) {
        String refreshToken = request.getRefreshToken();

        if (jwtProvider.getType(refreshToken) != JwtType.REFRESH)
            throw new CustomException(CustomErrorCode.INVALID_TOKEN_TYPE);

        String email = jwtProvider.getSubject(refreshToken);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        return jwtProvider.generateToken(email, user.getRole());
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponse me() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
