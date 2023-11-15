package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Lottery;

import java.util.List;

public interface iLotteryService {

    Lottery getLoteryById(int id);
    List<Lottery> getAllLoteries();

}
