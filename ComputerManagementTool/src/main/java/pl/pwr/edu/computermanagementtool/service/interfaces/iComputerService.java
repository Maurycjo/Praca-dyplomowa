package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Computer;

import java.util.List;

public interface iComputerService {

    Computer getComputerById(int id);
    List<Computer> getAllComputers();


}
