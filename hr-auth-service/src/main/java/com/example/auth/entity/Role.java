package com.example.auth.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    USER("HR"),ADMIN("ADMIN");

    String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
