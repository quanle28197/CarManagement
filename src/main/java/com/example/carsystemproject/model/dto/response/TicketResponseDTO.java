package com.example.carsystemproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDTO {
    private String destination;
    private String licensePlate;
    private String customerName;
    private LocalTime bookingTime;
}
