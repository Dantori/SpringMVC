package ru.trofimov.springmvcapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.servece.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("employee") Employee employee) {
        logger.info("EmployeeController event: createPage()");
        return "create_employee";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee) {
        employeeService.addNewEmployee(employee);
        logger.info("EmployeeController event: create()");
        return "redirect:/employee/info";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        logger.info("EmployeeController event: getById(" + id + ")");
        return "employee_info";
    }

    @GetMapping("/{id}/patch")
    public String patch(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        logger.info("EmployeeController event: patch(" + id + ")");
        return "employee_patch";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("employee") Employee employee) {
        employeeService.patchEmployeeById(id, employee);
        logger.info("EmployeeController event: update(" + id + ")");
        return "redirect:/employee/info";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        logger.info("EmployeeController event: info()");
        return "employee_info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeService.removeEmployeeById(id);
        logger.info("EmployeeController event: delete(" + id + ")");
        return "redirect:/employee/info";
    }
}
