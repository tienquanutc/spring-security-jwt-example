package com.example.springsecurityjwt.payload.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponsePayload {
    private Long id;
    private String name;
    private String email;
}
