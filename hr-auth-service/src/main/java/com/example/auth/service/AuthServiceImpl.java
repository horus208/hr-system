package com.example.auth.service;

import com.example.auth.dto.JwtValidationRequest;
import com.example.auth.dto.JwtValidationResponse;
import com.example.auth.dto.LoginRequest;
import com.example.auth.entity.Role;
import com.example.auth.exceptions.PasswordEmailAuthenticationException;
import com.example.auth.security.EmailPasswordAuthenticationProvider;
import com.example.auth.security.jwt.JwtProvider;
import com.example.auth.security.jwt.JwtProviderBeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier(JwtProviderBeans.jwtAuthentication)
    private JwtProvider jwtProvider;


    @Override
    public String login(LoginRequest loginRequest)
    {
        try
        {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPwd()));
            String jwt = jwtProvider.generateToken(loginRequest.getEmail());

            return jwt;



        }
        catch (AuthenticationException exception)
        {
            throw new PasswordEmailAuthenticationException("wrong password or email address");
        }

    }

    @Override
    public JwtValidationResponse validateToken(JwtValidationRequest jwtValidationRequest)
    {
        Authentication authentication =  jwtProvider.validate(jwtValidationRequest.getJwt());
        return new JwtValidationResponse(authentication.getName(),(Role)authentication.getAuthorities().stream().findFirst().get());
    }
}
