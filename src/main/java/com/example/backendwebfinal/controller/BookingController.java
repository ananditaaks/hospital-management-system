package com.example.backendwebfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.service.BookingStatusService;

@Controller
public class BookingController {

    @Autowired
    private BookingStatusService bookingStatusService;

    // Load booking status page
    @GetMapping("/addstatus")
    public String showBookingStatusPage(Model model) {
        model.addAttribute("appointmentStatus", new Appointment());
        return "bookingstatus";
    }

    // Search appointment status
    @PostMapping("/searchstatus")
    public String searchAppointmentStatus(@ModelAttribute Appointment formData, Model model) {
        Appointment appointment = bookingStatusService.get(formData.getValue());
        model.addAttribute("appointmentStatus", appointment);
        return "bookingstatus";
    }
}