package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.repository.DeviceCoreRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;

@Service
public class DeviceCoreService extends GenericDeviceService<DeviceCore> {

    public DeviceCoreService(DeviceCoreRepository repository, LotteryRepository lotteryRepository, OfficeRepository officeRepository) {
        super(repository, lotteryRepository, officeRepository);
    }


}
