package com.example.carsystemproject.model.dto.request;

import com.example.carsystemproject.model.entity.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarRequestDTO {
    private String licensePlate;
    private String type;
    private String color;
    private String company;
    private ParkingLot parkingLot;
}
