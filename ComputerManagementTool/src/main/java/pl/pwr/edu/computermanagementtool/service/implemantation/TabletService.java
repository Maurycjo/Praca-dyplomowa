package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Tablet;
import pl.pwr.edu.computermanagementtool.repository.TabletRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iTabletService;

import java.util.List;

@Service
public class TabletService implements iTabletService{
    private final TabletRepository tabletRepository;

    public TabletService(TabletRepository tabletRepository) {
        this.tabletRepository = tabletRepository;
    }

    @Override
    public Tablet getTabletById(int id) {
        return null;
    }

    @Override
    public List<Tablet> getAllTablets() {
        return null;
    }
}
