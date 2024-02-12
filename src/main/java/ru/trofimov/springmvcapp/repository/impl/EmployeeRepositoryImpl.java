package ru.trofimov.springmvcapp.repository.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final Logger logger = Logger.getLogger(EmployeeRepositoryImpl.class);

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
        logger.info("DataBase event: createNewEmployee(" + employee.getId() + ")");
    }

    @Override
    public List<Employee> findAllEmployees() {
        logger.info("DataBase event: findAllEmployees()");
        return employees;
    }

    @Override
    public Employee findEmployeeById(int id) {
        logger.info("DataBase event: findEmployeeById(" + id + ")");
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void updateEmployeeById(int id, Employee employee) {
        Employee employeeToBeUpdated = findEmployeeById(id);
        employeeToBeUpdated.setName(employee.getName());
        logger.info("DataBase event: updateEmployeeById()");
    }

    @Override
    public void deleteEmployeeById(int id) {
        employees.removeIf(employee -> employee.getId() == id);
        logger.info("DataBase event: deleteEmployeeById(" + id + ")");
    }
}
