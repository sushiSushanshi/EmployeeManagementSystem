package com.EmployeeManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String error;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String error) {
        this.timestamp = LocalDateTime.now();
        this.error = error;
    }
}
