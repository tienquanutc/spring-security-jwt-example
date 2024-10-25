package com.example.springsecurityjwt.mapper.impl;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.mapper.AuthenticationMapper;
import com.example.springsecurityjwt.mapper.UserMapper;
import com.example.springsecurityjwt.payload.authentication.AuthenticationResponsePayload;
import com.example.springsecurityjwt.payload.authentication.RegisterRequestPayload;
import com.example.springsecurityjwt.security.JwtService;
import com.example.springsecurityjwt.security.mapper.UserDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationMapperImpl implements AuthenticationMapper {

    private final JwtService jwtService;
    private final UserDetailsMapper userDetailsMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User toUser(RegisterRequestPayload request) {
        return User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .build();
    }

    @Override
    public AuthenticationResponsePayload toAuthenticationResponsePayload(User user) {
        UserDetails userDetails = userDetailsMapper.toUserDetails(user);
        return AuthenticationResponsePayload.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .token(jwtService.generateToken(userDetailsMapper.toUserDetails(user)))
                .roles(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .build();
    }
}
