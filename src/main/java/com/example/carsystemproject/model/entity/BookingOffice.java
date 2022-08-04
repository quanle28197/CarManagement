package com.example.carsystemproject.model.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeId", length = 20)
    private long id;

    @Column(name = "officeName", length = 50)
    @NotBlank(message = "name required")
    private String name;

    @Column(name = "officePhone", length = 11)
    @NotBlank(message = "phone required")
    private String phone;

    @Column(name = "officePlace", length = 50)
    @NotBlank(message = "place required")
    private String place;

    @Column(name = "officePrice", length = 20)
    @NotBlank(message = "price required")
    private long price;

    @NotBlank(message = "date required")
    private LocalDate startContractDeadline;

    @NotBlank(message = "date required")
    private LocalDate endContractDeadline;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private Trip trip;
}
