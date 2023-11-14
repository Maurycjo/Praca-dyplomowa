package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.repository.ComputerRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iComputerService;

import java.util.List;

@Service
public class ComputerService implements iComputerService{

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public Computer getComputerById(int id) {
        return null;
    }

    @Override
    public List<Computer> getAllComputers() {
        return null;
    }
}
