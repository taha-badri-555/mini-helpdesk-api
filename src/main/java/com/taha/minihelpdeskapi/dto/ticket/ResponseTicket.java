package com.taha.minihelpdeskapi.dto.ticket;

import com.taha.minihelpdeskapi.enums.Priority;
import com.taha.minihelpdeskapi.enums.TicketStatus;

import java.time.LocalDateTime;

public record ResponseTicket(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String title,
        String description,
        TicketStatus status,
        Priority priority,
        Long creatorUserId
) {
}
