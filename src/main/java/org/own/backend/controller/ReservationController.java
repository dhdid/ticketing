package org.own.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.own.backend.dto.Reservation.ReservationRequest;
import org.own.backend.dto.Reservation.ReservationResponse;
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
@Tag(name = "Reservation", description = "예약 관리 API")
public class ReservationController {

    private final ReservationService reservationService;


    @Operation(
            summary = "티켓 예약",
            description = "ticketId를 기반으로 좌석을 예약한다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "예약 성공"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 ticketId"),
            @ApiResponse(responseCode = "409", description = "이미 예약된 좌석")
    })
    @PostMapping
    public ResponseEntity<ReservationResponse> reserveTicket(
        @RequestBody ReservationRequest request
    ) {
        ReservationResponse response = reservationService.reserve(request.ticketId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
