package com.taha.minihelpdeskapi.dto.ticket;

import com.taha.minihelpdeskapi.enums.TicketStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTicketStatusRequest(
        @NotNull(message = "status can't be null.")
        TicketStatus status
) {
}
