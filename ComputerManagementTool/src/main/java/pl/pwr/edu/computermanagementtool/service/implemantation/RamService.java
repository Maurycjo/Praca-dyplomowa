package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Ram;
import pl.pwr.edu.computermanagementtool.repository.RamRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iRamService;

import java.util.List;

@Service
public class RamService implements iRamService{
    private final RamRepository ramRepository;

    public RamService(RamRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    @Override
    public Ram getRamById(int id) {
        return null;
    }

    @Override
    public List<Ram> getAllRams() {
        return null;
    }
}
