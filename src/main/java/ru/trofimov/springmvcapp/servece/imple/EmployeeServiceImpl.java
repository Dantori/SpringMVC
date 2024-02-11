package ru.trofimov.springmvcapp.servece.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.repository.EmployeeRepository;
import ru.trofimov.springmvcapp.servece.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.createNewEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Override
    public void patchEmployeeById(int id, Employee employee) {
        employeeRepository.updateEmployeeById(id, employee);
    }

    @Override
    public void removeEmployeeById(int id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
