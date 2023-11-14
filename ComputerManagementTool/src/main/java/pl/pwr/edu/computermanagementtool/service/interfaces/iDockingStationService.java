package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.DockingStation;

import java.util.List;

public interface iDockingStationService {

    DockingStation getDockingStationById(int id);
    List<DockingStation> getAllDockingStations();

}
