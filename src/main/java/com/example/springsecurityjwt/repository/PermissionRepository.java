package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.entity.Permission;
import com.example.springsecurityjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
