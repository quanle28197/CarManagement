package com.example.carsystemproject.service.car;

import com.example.carsystemproject.model.entity.Car;
import com.example.carsystemproject.model.entity.ParkingLot;
import com.example.carsystemproject.repository.CarRepository;
import com.example.carsystemproject.service.exception.ExistedException;
import com.example.carsystemproject.service.exception.NotFoundException;
import com.example.carsystemproject.service.parkingLot.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ParkingLotService parkingLotService;

    @Override
    public Car addCar(Car car) {
        if (carRepository.findCarByLicensePlate(car.getLicensePlate()).isPresent()) {
            throw new ExistedException("This car license " + car.getLicensePlate() + "existed");
        }
        return carRepository.save(car);
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return carRepository.findCarByLicensePlate(licensePlate)
                .orElseThrow(() -> new NotFoundException("This car license: " + licensePlate + "not found"));
    }

    @Override
    public List<Car> getAllCar(int pageNum, int pageSize) {
        return carRepository.findAll(PageRequest.of(pageNum, pageSize)).getContent();
    }

    @Override
    public Car addParkingLotToCar(String licensePlate, Long parkId) {
        ParkingLot parkingLot = parkingLotService.getParkingLotById(parkId);
        parkingLot.getCars().add(getCarByLicensePlate(licensePlate));
        Car car = getCarByLicensePlate(licensePlate);
        car.setParkingLot(parkingLot);
        return carRepository.save(car);
    }
}
