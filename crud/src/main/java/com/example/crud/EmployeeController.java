package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee.orElse(null));
        return "employee-detail";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        employeeService.createEmployee(employeeDTO);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.get().getId());
            employeeDTO.setName(employee.get().getName());
            employeeDTO.setRole(employee.get().getRole());
            model.addAttribute("employeeDTO", employeeDTO);
            model.addAttribute("employeeId", id);
            return "employee-edit";
        } else {
            return "redirect:/employees";
        }
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeId", id);
            return "employee-edit";
        }

        employeeService.updateEmployee(id, employeeDTO);
        return "redirect:/employees";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
