package com.example.carsystemproject.service.trip;

import com.example.carsystemproject.model.entity.Trip;
import com.example.carsystemproject.repository.TripRepository;
import com.example.carsystemproject.service.exception.ExistedException;
import com.example.carsystemproject.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService implements ITripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip addTrip(Trip trip) {
        if (tripRepository.findById(trip.getId()).isPresent()) {
            throw  new ExistedException("This trip id is: " + trip.getId() + "existed");
        }
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This trip id : " + id + "not found"));
    }

    @Override
    public List<Trip> getAllTrips(int pageNum, int pageSize) {
        return tripRepository.findAll(PageRequest.of(pageNum, pageSize)).getContent();
    }
}
