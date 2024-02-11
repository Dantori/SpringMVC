package ru.trofimov.springmvcapp.repository.impl;

import org.springframework.stereotype.Repository;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static int EMPLOYEE_ID = 0;
    private final List<Employee> employees;

    {
        employees = new ArrayList<>();

        employees.add(new Employee(++EMPLOYEE_ID, "Victor", "developer"));
        employees.add(new Employee(++EMPLOYEE_ID, "Ivan", "analyst"));
        employees.add(new Employee(++EMPLOYEE_ID, "Vlad", "marketer"));
    }

    @Override
    public void createNewEmployee(Employee employee) {
        employee.setId(++EMPLOYEE_ID);
        employees.add(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employees;
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void updateEmployeeById(int id, Employee employee) {
        Employee employeeToBeUpdated = findEmployeeById(id);
        employeeToBeUpdated.setName(employee.getName());
    }

    @Override
    public void deleteEmployeeById(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }
}
