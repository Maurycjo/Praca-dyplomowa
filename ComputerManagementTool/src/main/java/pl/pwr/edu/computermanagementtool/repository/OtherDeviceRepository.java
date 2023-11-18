package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.OtherDevice;

import java.util.List;

public interface OtherDeviceRepository extends JpaRepository<OtherDevice, Integer> {

    List<OtherDevice> findAllByReadyToSellIsTrue();
    List<OtherDevice> findAllByReadyToSellIsFalse();
    List<OtherDevice> findAllByOfficeId(int officeId);

}