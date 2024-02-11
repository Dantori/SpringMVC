package ru.trofimov.springmvcapp.repository;

import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.domain.Manager;

import java.util.List;

public interface ManagerRepository {

    void createManager(Manager manager);

    Manager findManagerById(int id);

    List<Manager> findAllManager();

    List<Employee> findManagersEmployees(Manager manager);

    void updateManager(int id, Manager manager);

    void deleteManagerById(int id);
}
