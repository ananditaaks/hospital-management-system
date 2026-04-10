package com.example.backendwebfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.service.BookingStatusService;


@Controller
public class BookingController {

    
    @Autowired
    private BookingStatusService service;
    


    @GetMapping("/addstatus")
    public String add(Model model) {
    	List<Appointment> listemployee = service.listAll();
        model.addAttribute("appointmentstatus", new Appointment());
        return "bookingstatus";
    }

    
    @PostMapping("/searchstatus")
     public String doSearchEmployee(@ModelAttribute Appointment formData, Model model) {
    	Appointment emp = service.get(formData.getValue());
            model.addAttribute("appointmentstatus", emp);
            return "bookingstatus";            
     }

}
