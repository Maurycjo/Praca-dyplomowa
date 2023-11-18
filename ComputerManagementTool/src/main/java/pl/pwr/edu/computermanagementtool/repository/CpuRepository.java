package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {
}