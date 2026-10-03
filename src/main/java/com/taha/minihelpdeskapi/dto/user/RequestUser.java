package com.taha.minihelpdeskapi.dto.user;

import com.taha.minihelpdeskapi.enums.Role;
import jakarta.validation.constraints.NotBlank;

public record RequestUser(
        @NotBlank
        String username,
        @NotBlank
        String password,
        Role role
) {
}
