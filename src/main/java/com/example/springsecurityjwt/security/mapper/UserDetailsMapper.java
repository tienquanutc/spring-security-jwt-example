package com.example.springsecurityjwt.security.mapper;

import com.example.springsecurityjwt.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

    UserDetails toUserDetails(User user);

}
