package com.example.carsystemproject.service.ticket;


import com.example.carsystemproject.model.entity.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket addTicket(Ticket ticket);

    Ticket getTicketbyId(Long id);

    List<Ticket> getAllTicket(int pageNumber, int pageSize);

    Ticket addCarAndTripToTicket(Long ticketId, String licensePlate, Long tripId);
}
