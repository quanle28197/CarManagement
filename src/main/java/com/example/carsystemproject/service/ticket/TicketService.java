package com.example.carsystemproject.service.ticket;

import com.example.carsystemproject.model.entity.Car;
import com.example.carsystemproject.model.entity.Ticket;
import com.example.carsystemproject.model.entity.Trip;
import com.example.carsystemproject.repository.TicketRepository;
import com.example.carsystemproject.service.car.CarService;
import com.example.carsystemproject.service.exception.ExistedException;
import com.example.carsystemproject.service.exception.NotFoundException;
import com.example.carsystemproject.service.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    private final TicketRepository ticketRepository;
    private final CarService carService;
    private final TripService tripService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, CarService carService, TripService tripService) {
        this.ticketRepository = ticketRepository;
        this.carService = carService;
        this.tripService = tripService;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        if (ticketRepository.findById(ticket.getId()).isPresent()) {
            throw new ExistedException("This ticket id: " + ticket.getId() + "existed");
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketbyId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This ticket id: " + id + "not found"));
    }

    @Override
    public List<Ticket> getAllTicket(int pageNumber, int pageSize) {
        return ticketRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public Ticket addCarAndTripToTicket(Long ticketId, String licensePlate, Long tripId) {
        Car car = carService.getCarByLicensePlate(licensePlate);
        car.getTickets().add(getTicketbyId(ticketId));
        Trip trip = tripService.getTripById(tripId);
        trip.getTickets().add(getTicketbyId(ticketId));
        Ticket ticket = getTicketbyId(ticketId);
        ticket.setCar(car);
        ticket.setTrip(trip);
        return ticketRepository.save(ticket);
    }
}
