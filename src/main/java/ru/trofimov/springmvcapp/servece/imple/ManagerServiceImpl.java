package ru.trofimov.springmvcapp.servece.imple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trofimov.springmvcapp.domain.Employee;
import ru.trofimov.springmvcapp.domain.Manager;
import ru.trofimov.springmvcapp.repository.ManagerRepository;
import ru.trofimov.springmvcapp.servece.ManagerService;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private static final Logger logger = Logger.getLogger(ManagerServiceImpl.class);
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void addManager(Manager manager) {
        managerRepository.createManager(manager);
        logger.info("ManagerService event: addManager()");
    }

    @Override
    public Manager getManagerById(int id) {
        logger.info("ManagerService event: getManagerById(" + id + ")");
        return managerRepository.findManagerById(id);
    }

    @Override
    public List<Manager> getAllManager() {
        logger.info("ManagerService event: getAllManager()");
        return managerRepository.findAllManager();
    }

    @Override
    public List<Employee> getManagersEmployees(Manager manager) {
        logger.info("ManagerService event: getManagersEmployees()");
        return managerRepository.findManagersEmployees(manager);
    }

    @Override
    public void patchManager(int id, Manager manager) {
        managerRepository.updateManager(id, manager);
        logger.info("ManagerService event: patchManager(" + id + ")");
    }

    @Override
    public void removeManagerById(int id) {
        managerRepository.deleteManagerById(id);
        logger.info("ManagerService event: removeManagerById(" + id + ")");
    }
}
