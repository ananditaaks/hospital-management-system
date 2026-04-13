package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.*;
import com.example.backendwebfinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppService appService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private LabService labService;

    // Load doctor dashboard
    @GetMapping
    public String showDoctorDashboard() {
        return "doctor/doctor";
    }

    // Display patient dashboard
    @GetMapping("/patient")
    public String showPatientDashboard(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "doctor/patientDoctor/patientDoctor";
    }

    // Display appointment dashboard
    @GetMapping("/appointment")
    public String showAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "doctor/appointmentDoctor/appointmentDoctor";
    }

    // Display donor dashboard
    @GetMapping("/donor")
    public String showDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/donorDoctor/donorDoctor";
    }

    // Display laboratory dashboard
    @GetMapping("/laboratory")
    public String showLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/laboratoryDoctor/laboratoryDoctor";
    }

    // Edit patient
    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "doctor/patientDoctor/editPatient";
    }

    // Edit appointment
    @GetMapping("/appointment/edit/{id}")
    public String editAppointment(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment", appService.getAppById(id));
        return "doctor/appointmentDoctor/editAppointment";
    }

    // Edit donor
    @GetMapping("/donor/edit/{id}")
    public String editDonor(@PathVariable Integer id, Model model) {
        model.addAttribute("donor", donorService.getDonorById(id));
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/donorDoctor/editDonor";
    }

    // Edit laboratory
    @GetMapping("/laboratory/edit/{id}")
    public String editLab(@PathVariable Integer id, Model model) {
        model.addAttribute("laboratory", labService.getLabById(id));
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/laboratoryDoctor/editLab";
    }

    // Delete appointment
    @GetMapping("/appointment/{id}")
    public String deleteAppointment(@PathVariable Integer id) {
        appService.deleteAppById(id);
        return "redirect:/doctor/appointment";
    }

    // Delete donor
    @GetMapping("/donor/{id}")
    public String deleteDonor(@PathVariable Integer id) {
        donorService.deleteDonorById(id);
        return "redirect:/doctor/donor";
    }

    // Delete patient
    @GetMapping("/patient/{id}")
    public String deletePatient(@PathVariable Integer id) {
        patientService.deletePatientById(id);
        return "redirect:/doctor/patient";
    }

    // Delete laboratory
    @GetMapping("/laboratory/{id}")
    public String deleteLab(@PathVariable Integer id) {
        labService.deleteLabById(id);
        return "redirect:/doctor/laboratory";
    }

    // Create patient
    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/doctor/patient";
    }

    // Create appointment
    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appService.saveApp(appointment);
        return "redirect:/doctor/appointment";
    }

    // Create donor
    @PostMapping("/donor")
    public String createDonor(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/doctor/donor";
    }

    // Create laboratory
    @PostMapping("/laboratory")
    public String createLab(@ModelAttribute Laboratory laboratory) {
        labService.saveLab(laboratory);
        return "redirect:/doctor/laboratory";
    }

    // Update appointment
    @PostMapping("/appointment/edit/{id}")
    public String updateAppointment(@PathVariable Integer id,
                                    @ModelAttribute("appointment") Appointment appointment,
                                    Model model) {

        Appointment existingApp = appService.getAppById(id);
        existingApp.setId(appointment.getId());
        existingApp.setFullName(appointment.getFullName());
        existingApp.setEmail(appointment.getEmail());
        existingApp.setMessage(appointment.getMessage());
        existingApp.setField(appointment.getField());

        appService.updateApp(existingApp);
        return "redirect:/doctor/appointment";
    }

    // Update patient
    @PutMapping("/patient/edit/{id}")
    public String updatePatient(@PathVariable Integer id,
                                @ModelAttribute("patient") Patient patient,
                                Model model) {

        Patient existingPatient = patientService.getPatientById(id);
        existingPatient.setId(patient.getId());
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setSex(patient.getSex());
        existingPatient.setAge(patient.getAge());
        existingPatient.setAppointment(patient.getAppointment());
        existingPatient.setDoctor(patient.getDoctor());

        patientService.updatePatient(existingPatient);
        return "redirect:/doctor/patient";
    }

    // Update laboratory
    @PostMapping("/laboratory/edit/{id}")
    public String updateLab(@PathVariable Integer id,
                            @ModelAttribute("laboratory") Laboratory laboratory,
                            Model model) {

        Laboratory existingLab = labService.getLabById(id);
        existingLab.setId(laboratory.getId());
        existingLab.setLabName(laboratory.getLabName());
        existingLab.setAddress(laboratory.getAddress());
        existingLab.setDonor(laboratory.getDonor());

        labService.updateLab(existingLab);
        return "redirect:/doctor/laboratory";
    }

    // Update donor
    @PostMapping("/donor/edit/{id}")
    public String updateDonor(@PathVariable Integer id,
                              @ModelAttribute("donor") Donor donor,
                              Model model) {

        Donor existingDonor = donorService.getDonorById(id);
        existingDonor.setId(donor.getId());
        existingDonor.setFullName(donor.getFullName());
        existingDonor.setEmail(donor.getEmail());
        existingDonor.setMessage(donor.getMessage());

        donorService.updateDonor(existingDonor);
        return "redirect:/doctor/donor";
    }
}