package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.*;
import com.example.backendwebfinal.repository.*;
import com.example.backendwebfinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppService appService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private LabService labService;

    // Load admin dashboard
    @GetMapping
    public String showAdminDashboard() {
        return "admin/index";
    }

    // Display doctor management page
    @GetMapping("/doctor")
    public String doctorIndex(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "admin/doctorAdmin/dashboard";
    }

    // Display patient dashboard
    @GetMapping("/patient")
    public String showPatientDashboard(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "admin/patient/patient";
    }

    // Display appointment dashboard
    @GetMapping("/appointment")
    public String showAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "admin/appointment/appointment";
    }

    // Display donor dashboard
    @GetMapping("/donor")
    public String showDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "admin/donor/donor";
    }

    // Display laboratory dashboard
    @GetMapping("/laboratory")
    public String showLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", labService.getAllLabs());
        model.addAttribute("users", userRepository.findAll());
        return "admin/laboratory/laboratory";
    }

    // Edit patient details
    @GetMapping("/patient/edit/{id}")
    public String editPatient(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "admin/patient/edit";
    }

    // Edit appointment
    @GetMapping("/appointment/edit/{id}")
    public String editAppointment(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment", appService.getAppById(id));
        return "admin/appointment/edit";
    }

    // Edit donor
    @GetMapping("/donor/edit/{id}")
    public String editDonor(@PathVariable Integer id, Model model) {
        model.addAttribute("donor", donorService.getDonorById(id));
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "admin/donor/edit";
    }

    // Edit laboratory
    @GetMapping("/laboratory/edit/{id}")
    public String editLab(@PathVariable Integer id, Model model) {
        model.addAttribute("laboratory", labService.getLabById(id));
        model.addAttribute("laboratories", labService.getAllLabs());
        model.addAttribute("users", userRepository.findAll());
        return "admin/laboratory/edit";
    }

    // Edit doctor
    @GetMapping("/doctor/edit/{id}")
    public String editDoctor(@PathVariable Integer id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "admin/doctorAdmin/edit";
    }

    // Delete appointment
    @GetMapping("/appointment/{id}")
    public String deleteAppointment(@PathVariable Integer id) {
        appService.deleteAppById(id);
        return "redirect:/admin/appointment";
    }

    // Delete donor
    @GetMapping("/donor/{id}")
    public String deleteDonor(@PathVariable Integer id) {
        donorService.deleteDonorById(id);
        return "redirect:/admin/donor";
    }

    // Delete patient
    @GetMapping("/patient/{id}")
    public String deletePatient(@PathVariable Integer id) {
        patientService.deletePatientById(id);
        return "redirect:/admin/patient";
    }

    // Delete laboratory
    @GetMapping("/laboratory/{id}")
    public String deleteLab(@PathVariable Integer id) {
        labService.deleteLabById(id);
        return "redirect:/admin/laboratory";
    }

    // Delete doctor
    @GetMapping("/doctor/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/admin/doctor";
    }

    // Create doctor
    @PostMapping("/doctor")
    public String createDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/admin/doctor";
    }

    // Create patient
    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/admin/patient";
    }

    // Create appointment
    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appService.saveApp(appointment);
        return "redirect:/admin/appointment";
    }

    // Create donor
    @PostMapping("/donor")
    public String createDonor(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/admin/donor";
    }

    // Create laboratory
    @PostMapping("/laboratory")
    public String createLab(@ModelAttribute Laboratory laboratory) {
        labService.saveLab(laboratory);
        return "redirect:/admin/laboratory";
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

        appService.updateApp(existingApp);
        return "redirect:/admin/appointment";
    }

    // Update patient
    @PostMapping("/patient/edit/{id}")
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
        return "redirect:/admin/patient";
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
        return "redirect:/admin/laboratory";
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
        return "redirect:/admin/donor";
    }

    // Update doctor
    @PostMapping("/doctor/edit/{id}")
    public String updateDoctor(@PathVariable Integer id,
                               @ModelAttribute("doctor") Doctor doctor,
                               Model model) {

        Doctor existingDoctor = doctorService.getDoctorById(id);
        existingDoctor.setId(doctor.getId());
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setSpecialty(doctor.getSpecialty());
        existingDoctor.setAddress(doctor.getAddress());
        existingDoctor.setMobileNo(doctor.getMobileNo());

        doctorService.updateDoctor(existingDoctor);
        return "redirect:/admin/doctor";
    }
}