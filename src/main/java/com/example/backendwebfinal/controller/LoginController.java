package com.example.backendwebfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Load login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}