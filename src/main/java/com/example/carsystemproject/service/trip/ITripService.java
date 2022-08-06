package com.example.carsystemproject.service.trip;

import com.example.carsystemproject.model.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITripService {
    Trip addTrip(Trip trip);

    Trip getTripById(Long id);

    List<Trip> getAllTrips(int pageNum, int pageSize);
}
