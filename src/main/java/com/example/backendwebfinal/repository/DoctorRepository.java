package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    List<Doctor> findBySpecialty(String specialty);

}