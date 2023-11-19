package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Cpu;
import pl.pwr.edu.computermanagementtool.repository.CpuRepository;
import pl.pwr.edu.computermanagementtool.service.CpuService;

@RestController
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
