package com.example.backendwebfinal.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@ToString
@Entity
@Table(name = "appointment")
public class Appointment {
	int i = ThreadLocalRandom.current().nextInt(100000, 1000000);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    
    @Column(name = "date")
    private String date;

    @Column(name = "message")
    private String message;
    
    @Column(name = "field",columnDefinition = "varchar(255) default 'Pending'")
    private String field;
    
    
    @Column(name="value",columnDefinition="INT NOT NULL")
    private int value = i;

    @OneToOne(mappedBy = "appointment")
    private Patient patient;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Appointment() {
    }

    public Appointment(String fullName, String email, String date, String message,String field,int value, Patient patient) {
        this.fullName = fullName;
        this.email = email;
        this.date = date;
        this.field=field;
        this.message = message;
    }

}
