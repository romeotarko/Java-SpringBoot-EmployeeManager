package com.example.employeemanager.service;
import ch.qos.logback.classic.Logger;
import com.example.employeemanager.dto.EmployeeCreateRequest;
import com.example.employeemanager.dto.EmployeeUpdateRequest;
import com.example.employeemanager.exception.EmployeeApplicationException;
import com.example.employeemanager.exception.UseNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UseNotFoundException("User by id" + id + "was not found"));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(EmployeeCreateRequest employeeCreateRequest) {

        if (employeeRepository.existsByEmail(employeeCreateRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST
                    , String.format("Employee with email {} already exists", employeeCreateRequest.getEmail()));
        }
        Employee employee = new Employee();
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setEmail(employeeCreateRequest.getEmail());
        employee.setName(employeeCreateRequest.getName());
        employee.setImageUrl(employeeCreateRequest.getImageUrl());
        employee.setJobTitle(employeeCreateRequest.getJobTitle());
        employee.setPhone(employeeCreateRequest.getPhone());

        return employeeRepository.saveAndFlush(employee);
    }

    public Employee updateEmployee(Long id, EmployeeUpdateRequest employeeUpdateRequest) {
        Employee employee = employeeRepository.getOne(id);
        employee.setEmail(employeeUpdateRequest.getEmail());
        employee.setPhone(employeeUpdateRequest.getPhone());
        employee.setImageUrl(employeeUpdateRequest.getImageUrl());
        employee.setJobTitle(employeeUpdateRequest.getJobTitle());

        return employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Long id) {
        checkIfEmployeeExists(id);
        employeeRepository.deleteById(id);
    }

    private void checkIfEmployeeExists(Long id) {
        if (!employeeRepository.existsById(id)) {
            log.debug("Employee with id {} does not exist!, id");
            throw new EmployeeApplicationException("Employee with id: " + id + " does not exist!"
                    , HttpStatus.NOT_FOUND);
        }
    }
}
