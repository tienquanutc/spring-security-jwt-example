package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.payload.authentication.RegisterRequestPayload;
import com.example.springsecurityjwt.payload.user.UserProfileResponsePayload;

public interface UserMapper {
    UserProfileResponsePayload toUserProfile(User user);
}
