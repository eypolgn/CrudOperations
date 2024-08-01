package com.example.crud;

public class OutputDTO {
    private Long id;
    private String name;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static OutputDTO fromEmployee(Employee employee) {
        OutputDTO dto = new OutputDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setRole(employee.getRole());
        return dto;
    }
}

