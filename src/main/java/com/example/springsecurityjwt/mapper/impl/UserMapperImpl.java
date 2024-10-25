package com.example.springsecurityjwt.mapper.impl;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.mapper.UserMapper;
import com.example.springsecurityjwt.payload.user.UserProfileResponsePayload;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapperImpl implements UserMapper {

    @Override
    public UserProfileResponsePayload toUserProfile(User user) {
        return UserProfileResponsePayload.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
