package com.example.carsystemproject.repository;

import com.example.carsystemproject.model.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>, PagingAndSortingRepository<ParkingLot, Long> {
}