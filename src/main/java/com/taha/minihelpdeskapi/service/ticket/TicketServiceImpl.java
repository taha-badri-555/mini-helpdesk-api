package com.taha.minihelpdeskapi.service.ticket;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.dto.ticket.ResponseTicket;
import com.taha.minihelpdeskapi.entity.Ticket;
import com.taha.minihelpdeskapi.enums.TicketStatus;
import com.taha.minihelpdeskapi.exception.TicketNotFoundException;
import com.taha.minihelpdeskapi.mapper.TicketsMapper;
import com.taha.minihelpdeskapi.repository.TicketRepository;
import com.taha.minihelpdeskapi.service.base.BaseServiceImpl;
import com.taha.minihelpdeskapi.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketServiceImpl extends BaseServiceImpl
        <
                Ticket,
                RequestTicket,
                ResponseTicket,
                TicketsMapper,
                TicketRepository
                > implements TicketService {
    public final UserService userService;

    public TicketServiceImpl(
            TicketRepository repository,
            TicketsMapper mapper, UserService userService) {
        super(repository, mapper);
        this.userService = userService;
    }

    @Override
    public Ticket findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new TicketNotFoundException("ticket not found whit ID: " + id));
    }

    @Override
    public Ticket createTicket(Long userId, RequestTicket requestTicket) {
        var user = userService.findById(userId);
        var ticket = Ticket.builder()
                .priority(requestTicket.priority())
                .status(TicketStatus.OPEN)
                .description(requestTicket.description())
                .title(requestTicket.title())
                .createdBy(user)
                .build();
        return save(ticket);
    }
}
