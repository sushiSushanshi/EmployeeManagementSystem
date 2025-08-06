package com.EmployeeManagement.dto;

import lombok.Data;

@Data
public class APIResponse<T> {
    private String message;
    private T data;
    private Object metadata;
}
