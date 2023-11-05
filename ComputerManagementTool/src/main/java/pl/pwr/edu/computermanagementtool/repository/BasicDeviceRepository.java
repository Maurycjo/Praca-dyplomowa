package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;

public interface BasicDeviceRepository extends JpaRepository<BasicDevice, Integer> {
}