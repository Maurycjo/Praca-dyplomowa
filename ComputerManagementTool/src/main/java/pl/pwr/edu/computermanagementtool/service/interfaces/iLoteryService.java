package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Lotery;

import java.util.List;

public interface iLoteryService {

    Lotery getLoteryById(int id);
    List<Lotery> getAllLoteries();

}
