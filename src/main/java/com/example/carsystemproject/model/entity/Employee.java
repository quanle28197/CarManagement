package com.example.carsystemproject.model.entity;

import com.example.carsystemproject.model.convert.BooleanToStringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", length = 20)
    private long id;

    @Column(length = 50)
    @NotNull(message = "account required")
    private String account;

    @Column(length = 10)
    @NotNull(message = "department required")
    private String department;

    @Column(name = "employeeAddress", length = 50)
    private String address;

    @Column(name = "employeeBirthdate")
    @NotNull(message = "birthdate required")
    private LocalDate birthdate;

    @Column(name = "employeeEmail", length = 50)
    private String email;

    @Column(name = "employeeName", length = 50)
    @NotNull(message = "name required")
    private String name;

    @Column(name = "employeePhone", length = 10)
    @NotNull(message = "phone required")
    private String phone;

    @Column(length = 20)
    @NotNull(message = "password required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$", message = "Password must match with criteria")
    private String password;

    @Column(length = 1)
    @NotNull(message = "sex required")
    @Convert(converter = BooleanToStringConverter.class)
    private boolean sex;

}
