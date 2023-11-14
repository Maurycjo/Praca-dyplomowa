package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Cpu;

import java.util.List;

public interface iCpuService {

    Cpu getCpuById(int id);
    List<Cpu> getAllCpus();
}
