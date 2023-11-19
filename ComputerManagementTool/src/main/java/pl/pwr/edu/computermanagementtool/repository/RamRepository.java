package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.Component;
import pl.pwr.edu.computermanagementtool.entity.Ram;

import java.util.Optional;

public interface RamRepository extends ComponentRepository<Ram>{


}