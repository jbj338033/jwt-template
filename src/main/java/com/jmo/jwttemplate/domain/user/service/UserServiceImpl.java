package com.jmo.jwttemplate.domain.user.service;

import com.jmo.jwttemplate.domain.user.domain.User;
import com.jmo.jwttemplate.domain.user.dto.response.UserResponse;
import com.jmo.jwttemplate.domain.user.error.UserError;
import com.jmo.jwttemplate.domain.user.repository.UserRepository;
import com.jmo.jwttemplate.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserResponse getMe() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));

        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
