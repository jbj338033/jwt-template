package com.jmo.jwttemplate.domain.auth.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String email, String refreshToken) {
        redisTemplate.opsForValue().set("refreshToken:" + email, refreshToken);
    }

    @Override
    public String findByEmail(String email) {
        return redisTemplate.opsForValue().get("refreshToken:" + email);
    }

    @Override
    public void deleteByEmail(String email) {
        redisTemplate.delete("refreshToken:" + email);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return redisTemplate.hasKey("refreshToken:" + email);
    }
}
