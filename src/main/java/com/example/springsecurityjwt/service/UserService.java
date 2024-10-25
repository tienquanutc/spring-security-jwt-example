package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.payload.user.UserProfileResponsePayload;

public interface UserService {

    UserProfileResponsePayload getUserProfile(String username);

}
