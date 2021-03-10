package com.example.employeemanager.service;

import com.example.employeemanager.dto.EmployeeCreateRequest;
import com.example.employeemanager.exception.UseNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee addEmployee(EmployeeCreateRequest employeeCreateRequest){
        Employee employee =new Employee();
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setEmail(employeeCreateRequest.getEmail());
        employee.setName(employeeCreateRequest.getName());
        employee.setImageUrl(employeeCreateRequest.getImageUrl());
        employee.setJobTitle(employeeCreateRequest.getJobTitle());
        employee.setPhone(employeeCreateRequest.getPhone());

        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() ->new UseNotFoundException("User by id"+ id + "was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
