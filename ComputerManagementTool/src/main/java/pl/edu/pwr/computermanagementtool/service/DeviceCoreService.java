package pl.edu.pwr.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.edu.pwr.computermanagementtool.entity.DeviceCore;
import pl.edu.pwr.computermanagementtool.repository.DeviceCoreRepository;
import pl.edu.pwr.computermanagementtool.repository.OfficeRepository;

@Service
public class DeviceCoreService extends GenericDeviceService<DeviceCore> {

    public DeviceCoreService(DeviceCoreRepository repository, OfficeRepository officeRepository) {
        super(repository, officeRepository);
    }


}
