package com.example.auth.security.userDetails;

import com.example.auth.entity.AppUser;

import com.example.auth.exceptions.PasswordEmailAuthenticationException;
import com.example.auth.persistance.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired

    private  PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Optional<AppUser> user = userRepo.findByEmail(email);
        if(user.isEmpty())
            throw new PasswordEmailAuthenticationException("wrong password or email address");
       return new AppUserDetails(user.get());

    }


}
