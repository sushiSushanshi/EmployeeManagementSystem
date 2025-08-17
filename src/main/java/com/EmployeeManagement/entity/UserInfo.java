package com.EmployeeManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserInfo {
    @Id
    private String username;
    private String password;
}
