package ru.trofimov.springmvcapp.servece;

import ru.trofimov.springmvcapp.domain.Employee;

import java.util.List;

public interface EmployeeService {

    void addNewEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void patchEmployeeById(int id, Employee employee);

    void removeEmployeeById(int id);
}
