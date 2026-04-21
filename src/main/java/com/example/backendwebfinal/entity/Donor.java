package com.example.backendwebfinal.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@Table(name = "donor")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @NotNull(message = "Full name is required")
    @Size(min = 2, max = 50)
    private String fullName;

    @Column(name = "email")
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @CreationTimestamp
    @Column(nullable = false)
    private Date date;

    @Column(name = "message")
    @NotNull(message = "Message is required")
    @Size(min = 5, max = 255)
    private String message;

    @ManyToOne
    @NotNull(message = "Laboratory is required")
    private Laboratory laboratory;

    public Donor() {
    }

    public Donor(String fullName, String email, Date date, String message, Laboratory laboratory) {
        this.fullName = fullName;
        this.email = email;
        this.date = date;
        this.message = message;
        this.laboratory = laboratory;
    }
}