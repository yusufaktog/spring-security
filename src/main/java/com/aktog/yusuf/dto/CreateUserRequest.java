package com.aktog.yusuf.dto;

import com.aktog.yusuf.model.enumation.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;


import java.util.Objects;
import java.util.Set;


public record CreateUserRequest(
        @NotBlank(message = "Username can not be blank")
        String name,
        @NotBlank(message = "Username can not be blank")
        @Size(min = 5, max = 64, message = "username length must be between 6 and 32")
        String username,
        @Size(min = 6, max = 32, message = "Password length must be between 6 and 32")
        String password,

        @NotNull(message = "not null")
        String mail,
        @NotEmpty(message = "It has to be given at least one role...")
        Set<UserRole> roles) {


}
