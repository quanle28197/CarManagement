package com.example.carsystemproject.model.dto.response;

import com.example.carsystemproject.model.entity.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarResponseDTO {
    private String licensePlate;
    private String type;
    private String color;
    private String company;
    private ParkingLot parkingLot;
}
