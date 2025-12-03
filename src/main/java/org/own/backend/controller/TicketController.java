package org.own.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.own.backend.dto.Ticket.TicketListResponse;
import org.own.backend.dto.Ticket.TicketResponse;
import org.own.backend.service.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Ticket", description = "티켓 조회 API")
public class TicketController {

    private final TicketService ticketService;

    @Operation(
            summary = "티켓 리스트 조회",
            description = "전체 ticket을 조회한다"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping
    public ResponseEntity<TicketListResponse> getTickets() {
        TicketListResponse tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @Operation(
            summary = "ticketId로 티켓 조회",
            description = "ticketId로 티켓을 조회한다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "유효하지 않은 ticketId"),
    })
    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable Long ticketId) {
        TicketResponse response = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(response);
    }

}
