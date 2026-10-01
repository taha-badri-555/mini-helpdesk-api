package com.taha.minihelpdeskapi.dto.ticket;

import com.taha.minihelpdeskapi.enums.Priority;
import com.taha.minihelpdeskapi.enums.TicketStatus;
import lombok.Builder;

@Builder
public record RequestTicket(
        Long id,
        String title,
        String description,
        TicketStatus status,
        Priority priority
) {
}
