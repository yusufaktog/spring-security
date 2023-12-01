package com.aktog.yusuf.dto;

import jakarta.validation.constraints.Size;

public record AuthRequest(
        String username,

        @Size(min = 15,message = "size")
        String password
) {
}
