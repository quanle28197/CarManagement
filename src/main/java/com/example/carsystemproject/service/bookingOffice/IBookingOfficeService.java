package com.example.carsystemproject.service.bookingOffice;

import com.example.carsystemproject.model.entity.BookingOffice;

import java.util.List;

public interface IBookingOfficeService {
    BookingOffice addBookingOffice(BookingOffice bookingOffice);

    BookingOffice getBookingOfficeById(Long id);

    List<BookingOffice> getAllBookingOffices(int pageNumber, int pageSize);

    BookingOffice addTripToBookingOffice(Long bookingOfficeId, Long tripId);
}
