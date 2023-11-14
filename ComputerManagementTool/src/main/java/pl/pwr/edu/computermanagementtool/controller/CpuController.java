package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Cpu;
import pl.pwr.edu.computermanagementtool.service.implemantation.CpuService;

import java.util.List;

@RestController
public class CpuController {


    private final CpuService cpuService;


    @Autowired
    public CpuController(CpuService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping("/cpu/{id}")
    Cpu getOneCpu(@PathVariable int id){
        return cpuService.getCpuById(id);
    }
    @GetMapping("/cpus")
    List<Cpu> getAllCpu(){
        return cpuService.getAllCpus();
    }

}
