package org.own.backend.dto.Ticket;

import org.own.backend.domain.ticket.Status;

public record TicketResponse(
        Long id,
        String seatNumber,
        Status status
) {}
