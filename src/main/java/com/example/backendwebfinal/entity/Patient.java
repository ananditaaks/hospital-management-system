package com.example.backendwebfinal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    @NotNull(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be 2-50 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "phone")
    @NotNull(message = "Phone is required")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;

    @Column(name = "sex")
    @NotNull(message = "Gender is required")
    private String sex;

    @Column(name = "age")
    @Min(value = 0, message = "Age must be positive")
    @Max(value = 120, message = "Age must be realistic")
    private int age;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "app_id", referencedColumnName = "id")
    private Appointment appointment;

    @NotNull(message = "Doctor is required")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String email, String phone, String sex, int age, Appointment appointment, Doctor doctor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.appointment = appointment;
        this.doctor = doctor;
    }
}