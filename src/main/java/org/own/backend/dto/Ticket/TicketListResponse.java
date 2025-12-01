package org.own.backend.dto.Ticket;

import java.util.List;

public record TicketListResponse(
        List<TicketResponse> tickets
) {}
