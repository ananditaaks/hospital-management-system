package com.example.backendwebfinal.service;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.entity.Doctor;
import com.example.backendwebfinal.repository.BookingStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingStatusService {
	@Autowired
    private BookingStatusRepository repo;
	
	public List<Appointment> listAll() {
        return (List<Appointment>)repo.findAll();
    }
     
    public Appointment get(int id) {
        return repo.findById(id).get();
    }
}
