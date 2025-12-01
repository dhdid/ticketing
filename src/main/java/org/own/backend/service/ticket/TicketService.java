package org.own.backend.service.ticket;

import org.own.backend.dto.Ticket.TicketListResponse;
import org.own.backend.dto.Ticket.TicketResponse;

public interface TicketService {

    TicketListResponse getAllTickets();

    TicketResponse getTicketById(Long ticketId);
}
