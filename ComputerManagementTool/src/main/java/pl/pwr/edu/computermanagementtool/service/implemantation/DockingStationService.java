package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.DockingStation;
import pl.pwr.edu.computermanagementtool.repository.DockingStationRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iDockingStationService;

import java.util.List;

@Service
public class DockingStationService implements iDockingStationService {

    private final DockingStationRepository dockingStationRepository;

    public DockingStationService(DockingStationRepository dockingStationRepository) {
        this.dockingStationRepository = dockingStationRepository;
    }

    @Override
    public DockingStation getDockingStationById(int id) {
        return null;
    }

    @Override
    public List<DockingStation> getAllDockingStations() {
        return null;
    }
}
