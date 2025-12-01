package org.own.backend.controller;


import lombok.RequiredArgsConstructor;
import org.own.backend.dto.Reservation.ReservationRequest;
import org.own.backend.dto.Reservation.ReservationResponse;
import org.own.backend.dto.Ticket.TicketListResponse;
import org.own.backend.service.reservation.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> reserveTicket(
        @RequestBody ReservationRequest request
    ) {
        ReservationResponse response = reservationService.reserve(request.ticketId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
