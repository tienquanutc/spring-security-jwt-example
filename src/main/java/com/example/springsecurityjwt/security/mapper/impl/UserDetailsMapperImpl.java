package com.example.springsecurityjwt.security.mapper.impl;

import com.example.springsecurityjwt.entity.Permission;
import com.example.springsecurityjwt.entity.Role;
import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.security.mapper.UserDetailsMapper;
import com.example.springsecurityjwt.security.model.UserDetailsImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserDetailsMapperImpl implements UserDetailsMapper {
    @Override
    public UserDetails toUserDetails(User user) {
        List<GrantedAuthority> roles = user.getRoles().stream()
                .map(it -> new SimpleGrantedAuthority("ROLE_" + it.getId()))
                .collect(Collectors.toList());

        List<GrantedAuthority> permissions = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(p -> new SimpleGrantedAuthority(p.getId()))
                .collect(Collectors.toList());

        Set<GrantedAuthority> authorities = new HashSet<>(roles.size() + permissions.size());
        authorities.addAll(roles);
        authorities.addAll(permissions);

        return UserDetailsImpl.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
