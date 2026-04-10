package com.example.backendwebfinal.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "laboratory")
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "lab_name")
    private String labName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private int phoneNo;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Donor> getDonor() {
		return donor;
	}

	public void setDonor(List<Donor> donor) {
		this.donor = donor;
	}

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "laboratory")
    private List<Donor> donor;

    public Laboratory() {
    }

    public Laboratory(String labName, String address, int phoneNo, List<Donor> donor) {
        this.labName = labName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.donor = donor;
    }
}
