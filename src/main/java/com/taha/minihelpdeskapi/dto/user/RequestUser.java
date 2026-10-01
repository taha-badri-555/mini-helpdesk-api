package com.taha.minihelpdeskapi.dto.user;

import com.taha.minihelpdeskapi.enums.Role;

public record RequestUser(
        String username,
        String password,
        Role role
) {
}
