package com.example.crud;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(nullable = false,name = "id")
    private Long id;

    @NotBlank(message = "Bu alan boş bırakılamaz, lütfen geçerli bir isim gir!")
    @Size(max = 50,message = "İsminiz 50 karakteri geçmemelidir.")
    @Column(nullable = false, name = "name", length = 50, unique = true)
    private String name;

    @NotBlank(message = "Bu alan boş bırakılamaz, lütfen geçerli bir rol gir!")
    @Size(max = 50, message = "Rolünüz 50 karakteri geçmemelidir.")
    @Column(nullable = false,name = "role",length = 50)
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

}
