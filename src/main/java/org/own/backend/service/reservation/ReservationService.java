package org.own.backend.service.reservation;

import org.own.backend.dto.Reservation.ReservationResponse;

public interface ReservationService {

    ReservationResponse reserve(Long ticketId);
}
