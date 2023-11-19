package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Cpu;
import pl.pwr.edu.computermanagementtool.entity.Ram;

import java.util.Optional;

@Repository
public interface CpuRepository extends ComponentRepository<Cpu> {



}