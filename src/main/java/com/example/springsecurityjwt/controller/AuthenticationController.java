package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.payload.ResponsePayload;
import com.example.springsecurityjwt.payload.authentication.LoginRequestPayload;
import com.example.springsecurityjwt.payload.authentication.RegisterRequestPayload;
import com.example.springsecurityjwt.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponsePayload> register(@Valid @RequestBody RegisterRequestPayload request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponsePayload
                        .builder()
                        .status(HttpStatus.CREATED)
                        .success(true)
                        .data(authenticationService.register(request))
                        .build()
                );
    }

    @PostMapping("/login")
    public ResponseEntity<ResponsePayload> login(@Valid @RequestBody LoginRequestPayload request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponsePayload
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(authenticationService.login(request))
                        .build()
                );
    }
}
