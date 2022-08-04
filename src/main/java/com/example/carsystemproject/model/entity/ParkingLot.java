package com.example.carsystemproject.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "parkingLot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkId", length = 20)
    private Long id;

    @Min(0)
    @Column(name = "parkArea", length = 20)
    @NotNull(message = "area required")
    private long area;

    @Column(name = "parkName", length = 50)
    @NotNull(message = "name required")
    private String name;

    @Column(name = "parkPlace", length = 50)
    @NotNull(message = "place required")
    private String place;

    @Min(0)
    @Column(name = "parkPrice", length = 50)
    private long price;

    @Column(name = "parkStatus", length = 50)
    @NotNull(message = "status required")
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Car> cars;
}
