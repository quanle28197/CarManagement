package com.example.carsystemproject.model.dto.request;

import com.example.carsystemproject.model.entity.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeRequestDTO {
    private String name;
    private Trip trip;
    private String phone;
    private String place;
    private Long price;
    private LocalDate startContractDeadline;
    private LocalDate endContractDeadline;
}
