package ru.trofimov.springmvcapp.repository.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.domain.Manager;
import ru.trofimov.springmvcapp.repository.ManagerRepository;
import ru.trofimov.springmvcapp.servece.EmployeeService;
import ru.trofimov.springmvcapp.servece.ManagerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ManagerRepositoryImpl implements ManagerRepository {

    private static final Logger logger = Logger.getLogger(ManagerRepositoryImpl.class);
    private final EmployeeService employeeService;


    @Autowired
    public ManagerRepositoryImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private static int MANAGER_ID = 0;
    private final List<Manager> managers;

    {
        managers = new ArrayList<>();

        managers.add(new Manager(++MANAGER_ID, "Andrew", "development", new ArrayList<>(Arrays.asList(1, 2, 3))));
        managers.add(new Manager(++MANAGER_ID, "Jil", "marketing", new ArrayList<>(Arrays.asList(1, 2, 3))));
    }


    @Override
    public void createManager(Manager manager) {
        manager.setId(++MANAGER_ID);
        managers.add(manager);
        logger.info("DataBase event: createManager(" + manager.getId() + ")");
    }

    @Override
    public Manager findManagerById(int id) {
        return managers.stream()
                .filter(manager -> manager.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Manager> findAllManager() {
        logger.info("DataBase event: findAllManager()");
        return managers;
    }

    @Override
    public List<Employee> findManagersEmployees(Manager manager) {
        List<Integer> employeesId = manager.getEmployeesId();
        List<Employee> managersEmployees = new ArrayList<>();
        for (Integer i : employeesId) {
            if (i != null) {
                managersEmployees.add(employeeService.getEmployeeById(i));
                logger.info("DataBase event: findManagersEmployees()");
            } else {
                throw new RuntimeException();
            }
        }
        return managersEmployees;
    }

    @Override
    public void updateManager(int id, Manager manager) {
        Manager managerToByUpdated = findManagerById(id);
        managerToByUpdated.setName(manager.getName());
        logger.info("DataBase event: updateManager(" + id + ")");
    }

    @Override
    public void deleteManagerById(int id) {
        managers.removeIf(manager -> manager.getId() == id);
        logger.info("DataBase event: deleteManagerById(" + id + ")");
    }
}
