package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public OutputDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee();
        Employee savedEmployee = employeeRepository.save(employee);
        return OutputDTO.fromEmployee(savedEmployee);
    }

    public OutputDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee();
        employee.setId(id);
        Employee updatedEmployee = employeeRepository.save(employee);
        return OutputDTO.fromEmployee(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
