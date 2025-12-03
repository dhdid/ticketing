package org.own.backend.service.reservation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.own.backend.domain.reservation.Reservation;
import org.own.backend.domain.ticket.Ticket;
import org.own.backend.dto.Reservation.ReservationRequest;
import org.own.backend.dto.Reservation.ReservationResponse;
import org.own.backend.repository.reservation.ReservationRepository;
import org.own.backend.repository.ticket.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;

    @Transactional
    public ReservationResponse reserve(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 티켓입니다."));

        ticket.reserve();

        var reservation = Reservation.builder()
                .ticket(ticket)
                .createdAt(LocalDateTime.now())
                .build();


        Reservation saved = reservationRepository.save(reservation);

        return new ReservationResponse(
                saved.getId(),
                saved.getTicket().getId(),
                saved.getCreatedAt()
        );
    }
}
