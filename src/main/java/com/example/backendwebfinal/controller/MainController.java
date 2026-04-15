package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.*;
import com.example.backendwebfinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private AppService appService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private LabService labService;

    @Autowired
    private DoctorService doctorService;

    // Load home page
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("donor", new Donor());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "index";
    }

    // Display doctor list
    @GetMapping("/doctor-list")
    public String showDoctorList(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor-list";
    }

    // Load booking status page
    @GetMapping("/bookingstatus")
    public String showBookingStatusPage() {
        return "bookingstatus";
    }

    // Load booking status form
    @GetMapping("/add")
    public String showBookingForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "bookingstatus";
    }

    // Search appointment
    @PostMapping("/search")
    public String searchAppointment(@ModelAttribute Appointment formData, Model model) {
        Appointment appointment = appService.getAppById(formData.getId());
        model.addAttribute("appointment", appointment);
        return "index";
    }

    // Create appointment
    @PostMapping("/")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appService.saveApp(appointment);
        return "index";
    }

    // Create donation
    @PostMapping("/donation")
    public String createDonation(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/";
    }
}