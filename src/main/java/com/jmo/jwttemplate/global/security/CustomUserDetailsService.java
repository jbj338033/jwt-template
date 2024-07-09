package com.jmo.jwttemplate.global.security;

import com.jmo.jwttemplate.domain.user.domain.User;
import com.jmo.jwttemplate.domain.user.repository.UserRepository;
import com.jmo.jwttemplate.global.exception.CustomErrorCode;
import com.jmo.jwttemplate.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));

        return new CustomUserDetails(user);
    }
}
