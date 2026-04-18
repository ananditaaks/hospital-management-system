package com.example.backendwebfinal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotNull(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be 2-50 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(name = "specialty")
    @NotNull(message = "Specialty is required")
    private String specialty;

    @Column(name = "address")
    @NotNull(message = "Address is required")
    private String address;

    @Column(name = "mobile_number")
    @NotNull(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNo;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.MERGE)
    private List<Patient> patient;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String specialty, String address, String mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.address = address;
        this.mobileNo = mobileNo;
    }
}