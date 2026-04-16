package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.User;
import com.example.backendwebfinal.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private MyUserDetailsService userDetailsService;

    // Provide default user object for form binding
    @ModelAttribute("user")
    public User createUserModel() {
        return new User();
    }

    // Load registration page
    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    // Handle user registration
    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") User user) {
        userDetailsService.saveUser(user);
        return "redirect:/login";
    }
}