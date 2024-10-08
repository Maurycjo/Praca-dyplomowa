package pl.edu.pwr.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.edu.pwr.computermanagementtool.entity.OtherDevice;
import pl.edu.pwr.computermanagementtool.repository.OfficeRepository;
import pl.edu.pwr.computermanagementtool.repository.OtherDeviceRepository;


@Service
public class OtherDeviceService extends GenericDeviceService<OtherDevice> {

    public OtherDeviceService(OtherDeviceRepository otherDeviceRepository, OfficeRepository officeRepository) {
        super(otherDeviceRepository, officeRepository);
    }


    public OtherDevice addOtherDevice(String deviceName, Double price, String description,
                                      Integer age, String officeAddress, String additionalInfo){

        OtherDevice otherDevice = (OtherDevice) addDevice(OtherDevice.class, deviceName, price,
                                                        description, age, officeAddress);
        otherDevice.setDeviceType(OtherDevice.DEVICE_TYPE);
        otherDevice.setAdditionalInfo(additionalInfo);

        return genericDeviceRepository.save(otherDevice);
    }

    public OtherDevice updateOtherDevice(int id, String deviceName, Double price, String description,
                                   Integer age, String officeAddress, String additionalInfo){


        OtherDevice otherDevice = updateDevice(id, deviceName, price, description, age, officeAddress);

        otherDevice.setAdditionalInfo(additionalInfo);



        return genericDeviceRepository.save(otherDevice);
    }


}
