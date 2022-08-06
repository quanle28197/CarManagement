package com.example.carsystemproject.controller;

import com.example.carsystemproject.model.dto.request.BookingOfficeRequestDTO;
import com.example.carsystemproject.model.dto.response.BookingOfficeResponseDTO;
import com.example.carsystemproject.model.entity.BookingOffice;
import com.example.carsystemproject.service.bookingOffice.BookingOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookingOffices")
public class BookingOfficeController {
    private final BookingOfficeService bookingOfficeService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookingOfficeController(BookingOfficeService bookingOfficeService, ModelMapper modelMapper) {
        this.bookingOfficeService = bookingOfficeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addBookingOffice(@RequestBody @Valid BookingOfficeRequestDTO bookingOfficeRequestDTO) {
        BookingOffice bookingOffice = modelMapper.map(bookingOfficeRequestDTO, BookingOffice.class);
        return new ResponseEntity<>(bookingOfficeService.addBookingOffice(bookingOffice), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllBookingOffice(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize) {
        List<BookingOfficeResponseDTO> bookings = bookingOfficeService.getAllBookingOffices(pageNum, pageSize)
                .stream()
                .map(bookingOffice -> modelMapper
                .map(bookingOffice, BookingOfficeResponseDTO.class))
                .collect(Collectors.toList());
        if (bookings.isEmpty()) {
            return new ResponseEntity<>("Empty List", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getBookingOfficeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(modelMapper.map(bookingOfficeService.getBookingOfficeById(id), BookingOfficeResponseDTO.class), HttpStatus.OK);
    }

    @PostMapping(value = "{bookingOfficeId}/{tripId}")
    public ResponseEntity<?> addTripToBookingOffice(@PathVariable("bookingOfficeId") Long bookingOfficeId, @PathVariable("tripId") Long tripId) {
        return new ResponseEntity<>(bookingOfficeService.addTripToBookingOffice(bookingOfficeId, tripId), HttpStatus.CREATED);
    }
}
