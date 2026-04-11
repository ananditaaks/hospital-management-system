package com.example.backendwebfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendwebfinal.entity.Appointment;

@Repository
public interface BookingStatusRepository extends JpaRepository<Appointment, Integer>{

}
