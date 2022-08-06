package com.example.carsystemproject.controller;

import com.example.carsystemproject.model.dto.request.TicketRequestDTO;
import com.example.carsystemproject.model.dto.response.TicketResponseDTO;
import com.example.carsystemproject.model.entity.Ticket;
import com.example.carsystemproject.service.ticket.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final  ModelMapper modelMapper;

    @Autowired
    public TicketController(TicketService ticketService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addTicket(@RequestBody @Valid TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = modelMapper.map(ticketRequestDTO, Ticket.class);
        return new ResponseEntity<>(ticketService.addTicket(ticket), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllTicket(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize) {
        List<TicketResponseDTO> tickets = ticketService.getAllTicket(pageNum, pageSize)
                .stream()
                .map(ticket -> modelMapper.map(ticket, TicketResponseDTO.class))
                .collect(Collectors.toList());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>("Empty List", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        }
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTicketById(@PathVariable("id") long id) {
        return new ResponseEntity<>(modelMapper.map(ticketService.getTicketbyId(id), TicketResponseDTO.class), HttpStatus.OK);
    }

    @PostMapping(value = "{ticketId}/{licensePlate}/{tripId}")
    public ResponseEntity<?> addCarAndTrip(@PathVariable("ticketId") Long ticketId, @PathVariable("licensePlate") String licensePlate, @PathVariable("tripId") Long tripId) {
        return new ResponseEntity<>(ticketService.addCarAndTripToTicket(ticketId, licensePlate, tripId), HttpStatus.CREATED);
    }

}
