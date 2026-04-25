package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    List<Appointment> findByDoctorId(int doctorId);

}

