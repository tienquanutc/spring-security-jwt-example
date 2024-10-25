package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.payload.authentication.AuthenticationResponsePayload;
import com.example.springsecurityjwt.payload.authentication.LoginRequestPayload;
import com.example.springsecurityjwt.payload.authentication.RegisterRequestPayload;

public interface AuthenticationService {

    AuthenticationResponsePayload register(RegisterRequestPayload request);

    AuthenticationResponsePayload login(LoginRequestPayload request);
}
