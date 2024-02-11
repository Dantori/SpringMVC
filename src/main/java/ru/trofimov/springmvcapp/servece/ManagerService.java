package ru.trofimov.springmvcapp.servece;

import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.domain.Manager;

import java.util.List;

public interface ManagerService {

    void addManager(Manager manager);

    Manager getManagerById(int id);

    List<Manager> getAllManager();

    List<Employee> getManagersEmployees(Manager manager);

    void patchManager(int id, Manager manager);

    void removeManagerById(int id);
}
