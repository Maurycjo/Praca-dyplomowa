package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iComputerService;

import java.util.List;

@Service
public class ComputerService extends GenericDeviceService<Computer>{


    public ComputerService(GenericDeviceRepository<Computer> genericDeviceRepository, OfficeRepository officeRepository, LotteryRepository lotteryRepository) {
        super(genericDeviceRepository, officeRepository, lotteryRepository);
    }
}
