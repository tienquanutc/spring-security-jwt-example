package com.example.springsecurityjwt.repository;

import java.util.Set;

public interface UserRepositoryCustom {

    Set<String> getRoles(Long userId);

    Set<String> getAuthorities(Long userId);

}
