package com.taha.minihelpdeskapi.service.ticket;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.dto.ticket.ResponseTicket;
import com.taha.minihelpdeskapi.entity.Ticket;
import com.taha.minihelpdeskapi.mapper.TicketsMapper;
import com.taha.minihelpdeskapi.repository.TicketRepository;
import com.taha.minihelpdeskapi.service.base.BaseServiceImpl;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
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
                > implements  TicketService {
    public TicketServiceImpl(
            TicketRepository repository,
            TicketsMapper mapper
           ) {
        super(repository, mapper);
    }

}
