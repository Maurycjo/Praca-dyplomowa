package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Cpu;
import pl.pwr.edu.computermanagementtool.repository.CpuRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iCpuService;

import java.util.List;
import java.util.Optional;

@Service
public class CpuService implements iCpuService{

    private final CpuRepository cpuRepository;

    public CpuService(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    @Override
    public Cpu getCpuById(int id) {
        Optional<Cpu> cpuOptional = cpuRepository.findById(id);
        return cpuOptional.orElseThrow(()->new RuntimeException("Cpu not found with id: " + id));
    }

    @Override
    public List<Cpu> getAllCpus() {
        return null;
    }
}
