package org.own.backend.service.ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.own.backend.domain.ticket.Ticket;
import org.own.backend.dto.Ticket.TicketListResponse;
import org.own.backend.dto.Ticket.TicketResponse;
import org.own.backend.repository.ticket.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public TicketListResponse getAllTickets() {
        var tickets = ticketRepository.findAll().stream()
                .map(ticket -> new TicketResponse(
                        ticket.getId(),
                        ticket.getSeatNumber(),
                        ticket.getStatus()
                ))
                .toList();

        return new TicketListResponse(tickets);
    }

    @Transactional(readOnly = true)
    public TicketResponse getTicketById(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 티켓입니다."));

        return new TicketResponse(
                ticket.getId(),
                ticket.getSeatNumber(),
                ticket.getStatus()
        );
    }
}
