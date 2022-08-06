package com.example.carsystemproject.repository;

import com.example.carsystemproject.model.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>, PagingAndSortingRepository<Trip, Long> {
}