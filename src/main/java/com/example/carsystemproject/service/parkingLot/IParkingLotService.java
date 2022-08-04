package com.example.carsystemproject.service.parkingLot;

import com.example.carsystemproject.model.entity.ParkingLot;

import java.util.List;

public interface IParkingLotService {
    ParkingLot addParkingLot(ParkingLot parkingLot);

    ParkingLot getParkingLotById(Long id);

    List<ParkingLot> getAllParkingLots(int pageNumber, int pageSize);
}
