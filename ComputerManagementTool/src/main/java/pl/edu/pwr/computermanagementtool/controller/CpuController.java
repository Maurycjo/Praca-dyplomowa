package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.computermanagementtool.entity.Cpu;
import pl.edu.pwr.computermanagementtool.repository.CpuRepository;
import pl.edu.pwr.computermanagementtool.service.CpuService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cpus")
public class CpuController extends ComponentController<Cpu> {

    private final CpuService cpuService;
    private final CpuRepository cpuRepository;

    public CpuController(CpuService cpuService, CpuRepository cpuRepository) {
        super(cpuService, cpuRepository);
        this.cpuService = cpuService;
        this.cpuRepository = cpuRepository;
    }
}
