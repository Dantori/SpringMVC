package ru.trofimov.springmvcapp.servece.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.domain.Manager;
import ru.trofimov.springmvcapp.repository.ManagerRepository;
import ru.trofimov.springmvcapp.servece.ManagerService;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void addManager(Manager manager) {
        managerRepository.createManager(manager);
    }

    @Override
    public Manager getManagerById(int id) {
        return managerRepository.findManagerById(id);
    }

    @Override
    public List<Manager> getAllManager() {
        return managerRepository.findAllManager();
    }

    @Override
    public List<Employee> getManagersEmployees(Manager manager) {
        return managerRepository.findManagersEmployees(manager);
    }

    @Override
    public void patchManager(int id, Manager manager) {
        managerRepository.updateManager(id, manager);
    }

    @Override
    public void removeManagerById(int id) {
        managerRepository.deleteManagerById(id);
    }
}
