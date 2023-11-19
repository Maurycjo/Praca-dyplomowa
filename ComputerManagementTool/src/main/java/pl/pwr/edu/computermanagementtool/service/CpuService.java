package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Cpu;
import pl.pwr.edu.computermanagementtool.entity.Ram;
import pl.pwr.edu.computermanagementtool.repository.ComponentRepository;
import pl.pwr.edu.computermanagementtool.repository.CpuRepository;

import java.util.Optional;


@Service
public class CpuService extends ComponentService<Cpu>{

    private final CpuRepository cpuRepository;
    protected CpuService(CpuRepository cpuRepository) {
        super(cpuRepository);
        this.cpuRepository = cpuRepository;
    }

    @Override
    public Cpu add(String name, Double price) {
        Optional<Cpu> cpuOptional = cpuRepository.findFirstByNameContains(name);
        Cpu cpu;
        if (cpuOptional.isPresent()) {
            cpu = cpuOptional.get();
            cpu.setPrice(price);
            return cpu;
        } else {
            cpu = new Cpu();
            cpu.setName(name);
            cpu.setPrice(price);
            return cpuRepository.save(cpu);
        }
    }
}
