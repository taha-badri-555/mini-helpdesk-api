package com.taha.minihelpdeskapi.dto.ticket;

import com.taha.minihelpdeskapi.enums.Priority;
import com.taha.minihelpdeskapi.enums.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RequestTicket(
        @NotBlank(message = "title can't be blank.")
        String title,

        @NotBlank(message = "description can't be blank.")
        String description,

        TicketStatus status,

        @NotNull(message = "priority can't be null.")
        Priority priority
) {
}
