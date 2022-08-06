package com.example.carsystemproject.model.dto.response;

import com.example.carsystemproject.model.entity.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeResponseDTO {
    private Long id;
    private String name;
    private Trip trip;
}
