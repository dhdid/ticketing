package org.own.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.own.backend.dto.Ticket.TicketListResponse;
import org.own.backend.dto.Ticket.TicketResponse;
import org.own.backend.service.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<TicketListResponse> getTickets() {
        TicketListResponse tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable Long ticketId) {
        TicketResponse response = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(response);
    }

}
