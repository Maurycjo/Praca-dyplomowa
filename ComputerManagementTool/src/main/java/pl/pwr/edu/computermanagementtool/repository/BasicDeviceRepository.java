package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;

import java.util.List;

@Repository
public interface BasicDeviceRepository extends JpaRepository<BasicDevice, Integer> {

    List<BasicDevice> findAllByReadyToSellIsTrue();
    List<BasicDevice> findAllByReadyToSellIsFalse();
    List<BasicDevice> findAllByOfficeId(int officeId);
}