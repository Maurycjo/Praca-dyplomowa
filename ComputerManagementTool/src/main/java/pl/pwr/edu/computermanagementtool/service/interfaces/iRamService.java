package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Ram;

import java.util.List;

public interface iRamService {

    Ram getRamById(int id);
    List<Ram> getAllRams();
}
