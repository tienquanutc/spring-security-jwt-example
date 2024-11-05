package com.example.springsecurityjwt.repository.impl;

import com.example.springsecurityjwt.repository.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Set<String> getRoles(Long userId) {
        String sql = """
                select role_id
                from "user"
                         join public.user_role ur on "user".id = ur.user_id
                where user_id=?
                """;
        return new HashSet<>(this.jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString(1), userId));
    }

    @Override
    public Set<String> getAuthorities(Long userId) {
        String sql = """
                select permission_id
                from "user"
                         join public.user_role ur on "user".id = ur.user_id
                         join public.role_permission rp on ur.role_id = rp.role_id
                where user_id=?
                """;
        return new HashSet<>(this.jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString(1), userId));
    }
}
