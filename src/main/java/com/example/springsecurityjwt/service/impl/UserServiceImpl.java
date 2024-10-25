package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.mapper.UserMapper;
import com.example.springsecurityjwt.payload.user.UserProfileResponsePayload;
import com.example.springsecurityjwt.repository.UserRepository;
import com.example.springsecurityjwt.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserProfileResponsePayload getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User " + username + " Not Found"));

        return userMapper.toUserProfile(user);
    }
}
