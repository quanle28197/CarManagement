package com.example.carsystemproject.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "car")
public class Car {

    @Id
    @Column(length = 50)
    private String licensePlate;

    @Column(name = "carColor", length = 11)
    private String color;

    @Column(name = "carType", length = 50)
    private String type;

    @Column(length = 50)
    @NotNull(message = "company required")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parkId", referencedColumnName = "parkId")
    private ParkingLot parkingLot;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
