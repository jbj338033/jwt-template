package com.jmo.jwttemplate.global.security.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtExceptionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (IllegalArgumentException e) {
            sendErrorResponse(response, HttpStatus.UNAUTHORIZED, e);
        } catch (ServletException e) {
            sendErrorResponse(response, HttpStatus.BAD_REQUEST, e);
        }
    }

    private void sendErrorResponse(HttpServletResponse response, HttpStatus status, Throwable e) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();

        map.put("message", e.getMessage());
        map.put("status", String.valueOf(status.value()));

        response.getWriter().write(mapper.writeValueAsString(map));
    }
}
