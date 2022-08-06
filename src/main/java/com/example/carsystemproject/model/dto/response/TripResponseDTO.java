package com.example.carsystemproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripResponseDTO {
    private String destination;
    private LocalTime departureTime;
    private String driver;
    private String carType;
    private int maximumOnlineTicketNumber;
    private LocalDate departureDate;
}
