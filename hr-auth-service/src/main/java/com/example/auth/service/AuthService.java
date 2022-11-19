package com.example.auth.service;

import com.example.auth.dto.JwtValidationRequest;
import com.example.auth.dto.JwtValidationResponse;
import com.example.auth.dto.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
    JwtValidationResponse validateToken(JwtValidationRequest jwtValidationRequest);
}
