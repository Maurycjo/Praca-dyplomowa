package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Office;

import java.util.List;

public interface iOfficeService {

    Office getOfficeById(int id);
    List<Office> getAllOffices();
}
