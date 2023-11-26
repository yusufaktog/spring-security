package com.aktog.yusuf.dto;

import com.aktog.yusuf.model.enumation.UserRole;

import java.util.Set;

public record CreateUserRequest (
        String name,
        String username,
        String password,
        Set<UserRole> roles
){}
