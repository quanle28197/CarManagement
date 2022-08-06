package com.example.carsystemproject.controller;

import com.example.carsystemproject.model.dto.request.TripRequestDTO;
import com.example.carsystemproject.model.dto.response.TripResponseDTO;
import com.example.carsystemproject.model.entity.Trip;
import com.example.carsystemproject.service.trip.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;
    private final ModelMapper modelMapper;

    @Autowired
    public TripController(TripService tripService, ModelMapper modelMapper) {
        this.tripService = tripService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addTrip(@RequestBody @Valid TripRequestDTO tripRequestDTO) {
        Trip trip  = modelMapper.map(tripRequestDTO, Trip.class);
        return new ResponseEntity<>(tripService.addTrip(trip), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllTrip(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")int pageSize) {
        List<TripResponseDTO> trips = tripService.getAllTrips(pageNum, pageSize).stream()
                .map(trip -> modelMapper.map(trip, TripResponseDTO.class))
                .collect(Collectors.toList());
        if (trips.isEmpty()) {
            return new ResponseEntity<>("Empy list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(trips, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTripById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(modelMapper.map(tripService.getTripById(id), TripResponseDTO.class), HttpStatus.OK);
    }
}
