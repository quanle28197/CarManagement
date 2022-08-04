package com.example.carsystemproject.repository;

import com.example.carsystemproject.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String>, PagingAndSortingRepository<Car, String> {
    Optional<Car> findCarByLicensePlate(String licensePlate);
}