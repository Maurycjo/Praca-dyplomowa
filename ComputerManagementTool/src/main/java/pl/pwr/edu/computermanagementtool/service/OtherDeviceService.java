package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.OtherDevice;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.repository.OtherDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iOtherDeviceService;

@Service
public class OtherDeviceService extends GenericDeviceService<OtherDevice> {

    public OtherDeviceService(OtherDeviceRepository otherDeviceRepository, LotteryRepository lotteryRepository, OfficeRepository officeRepository) {
        super(otherDeviceRepository, lotteryRepository, officeRepository);
    }


    public OtherDevice addOtherDevice(String deviceName, Double price, String description,
                                      Integer age, Boolean readyToSell, Integer officeId, String additionalInfo){

        OtherDevice otherDevice = (OtherDevice) addDevice(OtherDevice.class, deviceName, price,
                                                        description, age, readyToSell, officeId);
        otherDevice.setDeviceType(OtherDevice.DEVICE_TYPE);
        otherDevice.setAdditionalInfo(additionalInfo);

        return genericRepository.save(otherDevice);
    }

}
