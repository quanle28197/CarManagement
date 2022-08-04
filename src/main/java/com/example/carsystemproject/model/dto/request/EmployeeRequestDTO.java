package com.example.carsystemproject.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeRequestDTO {
    private String name;
    private String phone;
    private LocalDate birthDate;
    private boolean sex;
    private String address;
    private String email;
    private String account;
    private String password;
    private String department;
}
