package com.example.springsecurityjwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class JwtConfig {

    @Bean
    JwtService jwtService(){
        return new JwtService("4bf04870a95e3897a02f95eb5477afd89400154cbab8e1f596897f8608572552", Duration.ofHours(15).toMillis());
    }
}
