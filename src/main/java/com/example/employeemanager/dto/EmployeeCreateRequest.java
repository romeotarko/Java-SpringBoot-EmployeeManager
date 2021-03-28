package com.example.employeemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateRequest {
    private String name;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Please provide a valid email address")
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
}