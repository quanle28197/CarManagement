package com.example.carsystemproject.service.parkingLot;

import com.example.carsystemproject.model.entity.ParkingLot;
import com.example.carsystemproject.repository.ParkingLotRepository;
import com.example.carsystemproject.service.exception.ExistedException;
import com.example.carsystemproject.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService implements IParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        if (parkingLotRepository.findById(parkingLot.getId()).isPresent()) {
            throw new ExistedException("Parking Lot with this id " + parkingLot.getId() + " existed!");
        }
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot getParkingLotById(Long id) {
        return parkingLotRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Parking lot with this id " + id + " not found!"));
    }

    @Override
    public List<ParkingLot> getAllParkingLots(int pageNumber, int pageSize) {
        return parkingLotRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
}
