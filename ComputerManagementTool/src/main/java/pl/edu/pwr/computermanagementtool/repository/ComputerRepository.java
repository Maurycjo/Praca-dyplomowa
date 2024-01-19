package pl.edu.pwr.computermanagementtool.repository;

import org.springframework.stereotype.Repository;
import pl.edu.pwr.computermanagementtool.entity.Computer;

@Repository
public interface ComputerRepository extends GenericDeviceRepository<Computer> {


}