package ru.trofimov.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.servece.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("employee") Employee employee) {
        return "create_employee";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee) {
        employeeService.addNewEmployee(employee);
        return "redirect:/info";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee_info";
    }
}
