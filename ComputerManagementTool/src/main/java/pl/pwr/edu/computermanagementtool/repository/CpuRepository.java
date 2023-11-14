package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Cpu;

import java.util.List;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Integer> {

}