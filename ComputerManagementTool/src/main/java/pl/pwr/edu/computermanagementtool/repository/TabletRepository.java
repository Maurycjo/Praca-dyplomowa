package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.Tablet;

import java.util.List;

public interface TabletRepository extends JpaRepository<Tablet, Integer> {

    List<Tablet> findAllByReadyToSellIsTrue();
    List<Tablet> findAllByReadyToSellIsFalse();
    List<Tablet> findAllByOfficeId(int officeId);
}