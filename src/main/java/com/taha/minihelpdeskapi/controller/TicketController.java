package com.taha.minihelpdeskapi.controller;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.dto.ticket.ResponseTicket;
import com.taha.minihelpdeskapi.mapper.TicketsMapper;
import com.taha.minihelpdeskapi.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final TicketsMapper ticketMapper;


    @GetMapping("/{id}")
    public ResponseEntity<ResponseTicket> getTicketById(@PathVariable Long id) {
        var byId = ticketService.findById(id);
        return ResponseEntity.ok(ticketMapper.entityToResponse(byId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTicketById(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTicket> updateTicketById
            (@PathVariable Long id, @RequestBody RequestTicket requestTicket) {
        var byId = ticketService.findById(id);
        var update = ticketService.update(byId, requestTicket);
        return ResponseEntity.ok(ticketMapper.entityToResponse(update));

    }

    @PostMapping("{UserId}")
    public ResponseEntity<ResponseTicket> saveTicket(@PathVariable("UserId") Long userId, @RequestBody RequestTicket requestTicket) {
        var ticket = ticketService.createTicket(userId, requestTicket);
        var responseTicket = ticketMapper.entityToResponse(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseTicket);
    }
}
