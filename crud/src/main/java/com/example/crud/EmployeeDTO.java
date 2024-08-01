package com.example.crud;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Bu alan boş bırakılamaz, lütfen geçerli bir isim gir!")
    @Size(max = 50, message = "İsminiz 50 karakteri geçmemelidir.")
    private String name;

    @NotBlank(message = "Bu alan boş bırakılamaz, lütfen geçerli bir rol gir!")
    @Size(max = 50, message = "Rolünüz 50 karakteri geçmemelidir.")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.id);
        employee.setName(this.name);
        employee.setRole(this.role);
        return employee;
    }


}
