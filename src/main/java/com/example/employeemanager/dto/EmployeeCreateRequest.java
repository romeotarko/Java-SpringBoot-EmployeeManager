package com.example.employeemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateRequest {
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
}