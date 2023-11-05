package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.Lotery;

public interface LoteryRepository extends JpaRepository<Lotery, Integer> {
}