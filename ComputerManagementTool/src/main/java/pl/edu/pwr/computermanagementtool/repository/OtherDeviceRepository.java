package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.OtherDevice;

import java.util.List;

@Repository
public interface OtherDeviceRepository extends GenericDeviceRepository<OtherDevice> {



}