package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iLotteryService;

import java.util.List;

@Service
public class LotteryService implements iLotteryService {

    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    @Override
    public Lottery getLoteryById(int id) {
        return null;
    }

    @Override
    public List<Lottery> getAllLoteries() {
        return null;
    }
}
