package com.taha.minihelpdeskapi.dto.user;

import com.taha.minihelpdeskapi.enums.Role;

import java.time.LocalDateTime;

public record ResponseUser(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String username,
        Role role
) {
}
