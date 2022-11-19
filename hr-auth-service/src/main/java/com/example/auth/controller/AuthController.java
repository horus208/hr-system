package com.example.auth.controller;

import com.example.auth.dto.JwtValidationRequest;
import com.example.auth.dto.JwtValidationResponse;
import com.example.auth.dto.LoginRequest;
import com.example.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class AuthController
{
    @Autowired
    AuthService authService;
    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
    {
        String jwt = authService.login(loginRequest);

        return new ResponseEntity<>(jwt, HttpStatus.OK);

    }

    @PostMapping(path = "/validateToken")
    public ResponseEntity<?> validateToken(@RequestBody JwtValidationRequest jwtValidationRequest)
    {
       JwtValidationResponse response =  authService.validateToken(jwtValidationRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
