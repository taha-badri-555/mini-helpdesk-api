package com.taha.minihelpdeskapi.service.ticket;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.dto.ticket.ResponseTicket;
import com.taha.minihelpdeskapi.dto.ticket.UpdateTicketStatusRequest;
import com.taha.minihelpdeskapi.entity.Ticket;
import com.taha.minihelpdeskapi.enums.TicketStatus;
import com.taha.minihelpdeskapi.exception.TicketNotFoundException;
import com.taha.minihelpdeskapi.mapper.TicketsMapper;
import com.taha.minihelpdeskapi.repository.TicketRepository;
import com.taha.minihelpdeskapi.service.base.BaseServiceImpl;
import com.taha.minihelpdeskapi.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Page<Ticket> findByCreatedById(Long userId, Pageable pageable) {
        return repository.findByCreatedById(userId, pageable);
    }

    @Override
    public Ticket updateStatus(Long ticketId, UpdateTicketStatusRequest status) {
        var byId = findById(ticketId);
        byId.setStatus(status.status());
       return save(byId);
    }

    @Override
    public Map<TicketStatus, Long> getStats() {
        List<Ticket> all = repository.findAll();
        return all
                .stream()
                .collect
                        (Collectors.groupingBy(Ticket::getStatus, Collectors.counting()));
    }
}
