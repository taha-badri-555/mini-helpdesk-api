package com.taha.minihelpdeskapi.service.ticket;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.entity.Ticket;
import com.taha.minihelpdeskapi.service.base.BaseService;

public interface TicketService extends BaseService<Ticket, RequestTicket> {
    public Ticket createTicket(Long userId,RequestTicket requestTicket);
}
