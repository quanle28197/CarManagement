package com.example.carsystemproject.service.car;

import com.example.carsystemproject.model.entity.Car;
import com.example.carsystemproject.model.entity.Employee;

import java.util.List;

public interface ICarService {
    Car addCar(Car car);

    Car getCarByLicensePlate(String licensePlate);

    List<Car> getAllCar(int pageNum, int pageSize);

    Car addParkingLotToCar(String licensePlate, Long parkId);

    Iterable<Car> findAll();
}
