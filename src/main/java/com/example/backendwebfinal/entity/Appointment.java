package com.example.backendwebfinal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@ToString
@Entity
@Table(name = "appointment")
public class Appointment {

    // Random value generator
    private int i = ThreadLocalRandom.current().nextInt(100000, 1000000);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(name = "full_name")
    @NotNull(message = "Full name is required")
    @Size(min = 2, max = 50)
    private String fullName;

    @Column(name = "email")
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "date")
    @NotNull(message = "Date is required")
    private String date;

    @Column(name = "message")
    @NotNull(message = "Message is required")
    @Size(min = 5, max = 255)
    private String message;

    @Column(name = "field", columnDefinition = "varchar(255) default 'Pending'")
    private String field;

    @Column(name = "value", columnDefinition = "INT NOT NULL")
    private int value = i;

    @OneToOne(mappedBy = "appointment")
    private Patient patient;

    public Appointment() {
    }

    public Appointment(String fullName, String email, String date, String message, String field, int value, Patient patient) {
        this.fullName = fullName;
        this.email = email;
        this.date = date;
        this.field = field;
        this.message = message;
    }
}