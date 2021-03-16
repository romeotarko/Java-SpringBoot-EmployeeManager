package com.example.employeemanager.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
}
