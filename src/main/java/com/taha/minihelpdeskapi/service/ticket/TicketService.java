package com.taha.minihelpdeskapi.service.ticket;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.dto.ticket.UpdateTicketStatusRequest;
import com.taha.minihelpdeskapi.entity.Ticket;
import com.taha.minihelpdeskapi.enums.TicketStatus;
import com.taha.minihelpdeskapi.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TicketService extends BaseService<Ticket, RequestTicket> {
     Ticket createTicket(Long userId,RequestTicket requestTicket);
     Page<Ticket> findByCreatedById(Long userId, Pageable pageable);
     Ticket updateStatus(Long ticketId, UpdateTicketStatusRequest status);
     Map<TicketStatus, Long> getStats();
}
