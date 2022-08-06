package com.example.carsystemproject.repository;

import com.example.carsystemproject.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>, PagingAndSortingRepository<Ticket, Long> {
}