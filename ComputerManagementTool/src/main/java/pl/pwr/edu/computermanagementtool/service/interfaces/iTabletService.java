package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Tablet;

import java.util.List;

public interface iTabletService {

    Tablet getTabletById(int id);
    List<Tablet> getAllTablets();
}
