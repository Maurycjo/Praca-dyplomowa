package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.*;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.repository.OtherDeviceRepository;


@Service
public class OtherDeviceService extends GenericDeviceService<OtherDevice> {

    public OtherDeviceService(OtherDeviceRepository otherDeviceRepository, OfficeRepository officeRepository) {
        super(otherDeviceRepository, officeRepository);
    }


    public OtherDevice addOtherDevice(String deviceName, Double price, String description,
                                      Integer age, Boolean readyToSell, Integer officeId, String additionalInfo){

        OtherDevice otherDevice = (OtherDevice) addDevice(OtherDevice.class, deviceName, price,
                                                        description, age, readyToSell, officeId);
        otherDevice.setDeviceType(OtherDevice.DEVICE_TYPE);
        otherDevice.setAdditionalInfo(additionalInfo);

        return genericDeviceRepository.save(otherDevice);
    }

    public OtherDevice updateOtherDevice(int id, String deviceName, Double price, String description,
                                   Integer age, Boolean readyToSell, Integer officeId, String additionalInfo){


        OtherDevice otherDevice = updateDevice(id, deviceName, price, description, age, readyToSell, officeId);

        if(additionalInfo!=null) otherDevice.setAdditionalInfo(additionalInfo);



        return genericDeviceRepository.save(otherDevice);
    }


}
