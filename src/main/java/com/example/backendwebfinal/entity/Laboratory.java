package com.example.backendwebfinal.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lab_name")
    @NotNull(message = "Lab name is required")
    @Size(min = 2, max = 100)
    private String labName;

    @Column(name = "address")
    @NotNull(message = "Address is required")
    private String address;

    @Column(name = "phone")
    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phoneNo;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "laboratory")
    private List<Donor> donor;

    public Laboratory() {
    }

    public Laboratory(String labName, String address, String phoneNo, List<Donor> donor) {
        this.labName = labName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.donor = donor;
    }
}