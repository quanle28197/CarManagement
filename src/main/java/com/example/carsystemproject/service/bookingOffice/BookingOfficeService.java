package com.example.carsystemproject.service.bookingOffice;

import com.example.carsystemproject.model.entity.BookingOffice;
import com.example.carsystemproject.model.entity.Trip;
import com.example.carsystemproject.repository.BookingOfficeRepository;
import com.example.carsystemproject.service.exception.ExistedException;
import com.example.carsystemproject.service.exception.NotFoundException;
import com.example.carsystemproject.service.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingOfficeService implements IBookingOfficeService {
    private final BookingOfficeRepository bookingOfficeRepository;
    private final TripService tripService;

    @Autowired
    public BookingOfficeService(BookingOfficeRepository bookingOfficeRepository, TripService tripService) {
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripService = tripService;
    }

    @Override
    public BookingOffice addBookingOffice(BookingOffice bookingOffice) {
        if (bookingOfficeRepository.findById(bookingOffice.getId()).isPresent()) {
            throw new ExistedException("This Booking id: " + bookingOffice.getId() + "existed");
        }
        return bookingOfficeRepository.save(bookingOffice);
    }

    @Override
    public BookingOffice getBookingOfficeById(Long id) {
        return bookingOfficeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This booking id : " + id + "not found"));
    }

    @Override
    public List<BookingOffice> getAllBookingOffices(int pageNumber, int pageSize) {
        return bookingOfficeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public BookingOffice addTripToBookingOffice(Long bookingOfficeId, Long tripId) {
        Trip trip = tripService.getTripById(tripId);
        trip.getBookingOffices().add(getBookingOfficeById(bookingOfficeId));
        BookingOffice bookingOffice = getBookingOfficeById(bookingOfficeId);
        bookingOffice.setTrip(trip);
        return bookingOfficeRepository.save(bookingOffice);
    }
}
