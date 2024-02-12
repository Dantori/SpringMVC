package ru.trofimov.springmvcapp.servece.imple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.repository.EmployeeRepository;
import ru.trofimov.springmvcapp.repository.impl.ManagerRepositoryImpl;
import ru.trofimov.springmvcapp.servece.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.createNewEmployee(employee);
        logger.info("EmployeeService event: addNewEmployee()");
    }

    @Override
    public Employee getEmployeeById(int id) {
        logger.info("EmployeeService event: getEmployeeById(" + id + ")");
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("EmployeeService event: getAllEmployees()");
        return employeeRepository.findAllEmployees();
    }

    @Override
    public void patchEmployeeById(int id, Employee employee) {
        employeeRepository.updateEmployeeById(id, employee);
        logger.info("EmployeeService event: patchEmployeeById(" + id + ")");
    }

    @Override
    public void removeEmployeeById(int id) {
        employeeRepository.deleteEmployeeById(id);
        logger.info("EmployeeService event: removeEmployeeById(" + id + ")");
    }
}
