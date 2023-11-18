package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;

@Repository
public interface ComputerRepository extends GenericDeviceRepository<Computer> {


}