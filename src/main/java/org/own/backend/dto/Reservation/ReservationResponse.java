package org.own.backend.dto.Reservation;

import java.time.LocalDateTime;

public record ReservationResponse(
        Long reservationId,
        Long ticketId,
        LocalDateTime createdAt) {}
