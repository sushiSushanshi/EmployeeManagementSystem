package com.EmployeeManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @NotNull
    private String name;
    @Column(unique = true)
    private String email;
    @NotNull
    private Department department;
    private String address;
    @NotNull
    private String phoneNumber;
    private String designation;
    private String accessRole;

}
