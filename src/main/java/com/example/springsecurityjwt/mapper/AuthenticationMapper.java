package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.payload.authentication.AuthenticationResponsePayload;
import com.example.springsecurityjwt.payload.authentication.RegisterRequestPayload;

public interface AuthenticationMapper {
    User toUser(RegisterRequestPayload payload);

    AuthenticationResponsePayload toAuthenticationResponsePayload(User user);

}
