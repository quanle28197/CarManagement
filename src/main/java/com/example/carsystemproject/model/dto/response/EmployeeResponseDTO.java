package com.example.carsystemproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private LocalDate birthdate;
    private String address;
    private String phone;
    private String department;
}
