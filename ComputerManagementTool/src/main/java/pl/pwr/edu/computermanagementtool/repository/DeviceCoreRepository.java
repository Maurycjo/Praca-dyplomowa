package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;

@Repository
@Primary
public interface DeviceCoreRepository extends GenericDeviceRepository<DeviceCore> {


}