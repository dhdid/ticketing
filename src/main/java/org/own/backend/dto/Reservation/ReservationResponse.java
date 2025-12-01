package org.own.backend.dto.Reservation;

public record ReservationResponse(
        Long reservationId,
        Long ticketId
) {}
