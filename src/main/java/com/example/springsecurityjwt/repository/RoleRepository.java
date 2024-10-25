package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findById(String roleId);

}
