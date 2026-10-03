package com.taha.minihelpdeskapi.dto.ticket;

import com.taha.minihelpdeskapi.enums.TicketStatus;

public record UpdateTicketStatusRequest(
        TicketStatus status
) {
}
