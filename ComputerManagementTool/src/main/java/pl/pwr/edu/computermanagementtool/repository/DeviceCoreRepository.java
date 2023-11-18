package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;

import java.util.List;

public interface DeviceCoreRepository extends JpaRepository<DeviceCore, Integer> {

    List<DeviceCore> findAllByReadyToSellIsTrue();
    List<DeviceCore> findAllByReadyToSellIsFalse();
    List<DeviceCore> findAllByOfficeId(int officeId);

}