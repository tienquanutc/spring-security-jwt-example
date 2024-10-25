package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.entity.Role;
import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.mapper.AuthenticationMapper;
import com.example.springsecurityjwt.mapper.UserMapper;
import com.example.springsecurityjwt.payload.authentication.AuthenticationResponsePayload;
import com.example.springsecurityjwt.payload.authentication.LoginRequestPayload;
import com.example.springsecurityjwt.payload.authentication.RegisterRequestPayload;
import com.example.springsecurityjwt.repository.RoleRepository;
import com.example.springsecurityjwt.repository.UserRepository;
import com.example.springsecurityjwt.service.AuthenticationService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationMapper authenticationMapper;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponsePayload register(RegisterRequestPayload request) {
        if (userRepository.existsByUsernameOrEmail(request.getUsername(), request.getEmail())) {
            throw new EntityExistsException("Username or Email is already exists");
        }
        Role userRole = roleRepository.findById("USER").orElseThrow(() -> new EntityNotFoundException("Role USER NotFound"));
        User user = userRepository.save(authenticationMapper.toUser(request));
        user.setRoles(Collections.singleton(userRole));
        return authenticationMapper.toAuthenticationResponsePayload(user);
    }

    @Override
    public AuthenticationResponsePayload login(LoginRequestPayload request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User " + request.getUsername() + " Not Found"));

        return authenticationMapper.toAuthenticationResponsePayload(user);
    }
}
