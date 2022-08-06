package com.example.carsystemproject.model.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tripId", length = 20)
    private Long id;

    @Min(0)
    @Column(length = 11)
    private int bookedTicketNumber;

    @Column(length = 50)
    private String carType;

    @NotNull(message = "date required")
    private LocalDate departureDate;

    @NotNull(message = "time required")
    private LocalTime departureTime;

    @Column(length = 50)
    @NotNull(message = "destination required")
    private String destination;

    @Column(length = 50)
    @NotNull(message = "driver required")
    private String driver;

    @Min(0)
    @Column(length = 11)
    @NotNull(message = "maximum online ticket number required")
    private int maximumOnlineTicketNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip", cascade = CascadeType.ALL)
    private List<BookingOffice> bookingOffices;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
