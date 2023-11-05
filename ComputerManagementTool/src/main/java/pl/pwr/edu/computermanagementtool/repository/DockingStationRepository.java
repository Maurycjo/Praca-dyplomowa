package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.DockingStation;

public interface DockingStationRepository extends JpaRepository<DockingStation, Integer> {
}