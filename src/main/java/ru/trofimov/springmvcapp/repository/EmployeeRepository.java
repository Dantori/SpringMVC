package ru.trofimov.springmvcapp.repository;

import ru.trofimov.springmvcapp.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

    void createNewEmployee(Employee employee);

    Employee findEmployeeById(int id);

    List<Employee> findAllEmployees();

    void updateEmployeeById(int id, Employee employee);

    void deleteEmployeeById(int id);
}
