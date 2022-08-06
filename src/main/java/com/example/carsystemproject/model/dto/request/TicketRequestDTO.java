package com.example.carsystemproject.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDTO {
    private String customerName;

    private LocalTime bookingTime;

    private String destination;

    private String licensePlate;
}
