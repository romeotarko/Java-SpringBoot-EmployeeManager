package com.example.employeemanager.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Job title must not be empty")
    private String jobTitle;

    @NotBlank(message = "Phone number must not be empty")
    private String phone;
    private String imageUrl;
}
