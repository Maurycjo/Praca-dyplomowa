package pl.edu.pwr.computermanagementtool.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.computermanagementtool.entity.DeviceCore;

@Repository
@Primary
public interface DeviceCoreRepository extends GenericDeviceRepository<DeviceCore> {


}