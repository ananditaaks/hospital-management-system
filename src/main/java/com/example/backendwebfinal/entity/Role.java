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
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Role name is required")
    @Size(min = 2, max = 50)
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}