package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}