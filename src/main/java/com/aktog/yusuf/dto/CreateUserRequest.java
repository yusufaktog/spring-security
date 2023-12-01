package com.aktog.yusuf.dto;

import com.aktog.yusuf.model.enumation.UserRole;
import com.aktog.yusuf.validation.EbebekMail;
import com.aktog.yusuf.validation.StrongPassword;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;


import java.util.Objects;
import java.util.Set;


public record CreateUserRequest(
        @NotBlank
        String name,
        @Size(min = 5, max = 64)
        String username,
        @Size(min = 6, max = 32)
        @StrongPassword
        String password,

        @EbebekMail
        String mail,
        @NotEmpty(message = "It has to be given at least one role...")
        Set<UserRole> roles) {


}
