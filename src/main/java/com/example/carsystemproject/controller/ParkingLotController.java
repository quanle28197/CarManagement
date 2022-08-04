package com.example.carsystemproject.controller;

import com.example.carsystemproject.model.dto.request.ParkingLotRequestDTO;
import com.example.carsystemproject.model.dto.response.ParkingLotResponseDTO;
import com.example.carsystemproject.model.entity.ParkingLot;
import com.example.carsystemproject.service.parkingLot.ParkingLotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "api/v1/parkinglots")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;
    private final ModelMapper modelMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ModelMapper modelMapper) {
        this.parkingLotService = parkingLotService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addParkingLot(@RequestBody @Valid ParkingLotRequestDTO parkingLotRequestDTO) {
        ParkingLot parkingLot = modelMapper.map(parkingLotRequestDTO, ParkingLot.class);
        return new ResponseEntity<>(parkingLotService.addParkingLot(parkingLot), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllParkingLots(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "3") int pageSize) {
        List<ParkingLotResponseDTO> parkingLots = parkingLotService.getAllParkingLots(pageNumber, pageSize).stream().map(parkingLot -> modelMapper.map(parkingLot, ParkingLotResponseDTO.class)).collect(Collectors.toList());
        if (parkingLots.isEmpty()) {
            return new ResponseEntity<>("Empty list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(parkingLots, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTripById(@PathVariable("id") long id) {
        return new ResponseEntity<>(modelMapper.map(parkingLotService.getParkingLotById(id), ParkingLotResponseDTO.class), HttpStatus.OK);
    }
}
