package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.repository.DeviceCoreRepository;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;

import java.util.Optional;

@Service
public class DeviceCoreService extends GenericDeviceService<DeviceCore> {

    public DeviceCoreService(DeviceCoreRepository repository, LotteryRepository lotteryRepository, OfficeRepository officeRepository) {
        super(repository, lotteryRepository, officeRepository);
    }



}
