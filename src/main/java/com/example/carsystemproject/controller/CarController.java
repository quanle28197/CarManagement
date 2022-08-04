package com.example.carsystemproject.controller;

import com.example.carsystemproject.model.dto.request.CarRequestDTO;
import com.example.carsystemproject.model.dto.response.CarResponseDTO;
import com.example.carsystemproject.model.entity.Car;
import com.example.carsystemproject.service.car.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final ModelMapper modelMapper;

    @Autowired
    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addCar(@RequestBody @Valid CarRequestDTO carRequestDTO) {
        Car car = modelMapper.map(carRequestDTO, Car.class);
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllCars(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "3") int pageSize) {
        List<CarResponseDTO> cars = carService.getAllCar(pageNum, pageSize)
                .stream()
                .map(car -> modelMapper.map(car, CarResponseDTO.class))
                .collect(Collectors.toList());
        if (cars.isEmpty()) {
            return new ResponseEntity<>("Empty list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getCarByLicensePlate(@PathVariable("id") String licensePlate) {
        return new ResponseEntity<>(modelMapper.
                map(carService.getCarByLicensePlate(licensePlate), CarResponseDTO.class), HttpStatus.OK);
    }
}
