package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Lotery;
import pl.pwr.edu.computermanagementtool.repository.LoteryRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iLoteryService;

import java.util.List;

@Service
public class LoteryService implements iLoteryService{

    private final LoteryRepository loteryRepository;

    public LoteryService(LoteryRepository loteryRepository) {
        this.loteryRepository = loteryRepository;
    }

    @Override
    public Lotery getLoteryById(int id) {
        return null;
    }

    @Override
    public List<Lotery> getAllLoteries() {
        return null;
    }
}
