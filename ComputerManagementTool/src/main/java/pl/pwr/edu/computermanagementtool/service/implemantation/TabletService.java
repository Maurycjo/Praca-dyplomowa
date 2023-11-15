package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Tablet;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iTabletService;

import java.util.List;

@Service
public class TabletService extends GenericDeviceService<Tablet>{

    public TabletService(GenericDeviceRepository<Tablet> genericDeviceRepository, OfficeRepository officeRepository, LotteryRepository lotteryRepository) {
        super(genericDeviceRepository, officeRepository, lotteryRepository);
    }
}
