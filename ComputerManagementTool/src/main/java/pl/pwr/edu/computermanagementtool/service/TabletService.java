package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.entity.Tablet;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.repository.TabletRepository;

import java.util.Optional;

@Service
public class TabletService extends GenericDeviceService<Tablet>{

    public TabletService(TabletRepository tabletRepository, LotteryRepository lotteryRepository, OfficeRepository officeRepository){
        super(tabletRepository, lotteryRepository, officeRepository);
    }

    public Tablet addTablet(String deviceName, Double price, String description,
                            Integer age, Boolean readyToSell, Integer officeId,
                            String screenSize, String operatingSystem, String batteryLife){

        Tablet tablet = (Tablet) addDevice(Tablet.class, deviceName, price, description,
                                                                age, readyToSell, officeId);

        tablet.setScreenSize(screenSize);
        tablet.setOperatingSystem(operatingSystem);
        tablet.setBatteryLife(batteryLife);

        return genericRepository.save(tablet);
    }

    public Tablet updateTablet(int id, String deviceName, Double price, String description,
                               Integer age, Boolean readyToSell, Integer officeId,
                               String screenSize, String operatingSystem, String batteryLife) {

        Optional<Tablet> basicDeviceOptional = genericRepository.findById(id);
        Tablet tablet = basicDeviceOptional.orElseThrow(() -> new RuntimeException("Tablet not fount with id: " + id));
        tablet.setDeviceName(deviceName);
        tablet.setPrice(price);
        tablet.setDescription(description);
        tablet.setAge(age);
        tablet.setReadyToSell(readyToSell);
        tablet.setScreenSize(screenSize);
        tablet.setOperatingSystem(operatingSystem);
        tablet.setBatteryLife(batteryLife);

        if (officeId != null) {
            Optional<Office> officeOptional = officeRepository.findById(officeId);
            Office office = officeOptional.orElseThrow(() -> new RuntimeException("Office not found with id: " + officeId));
            tablet.setOffice(office);
        }

        return tablet;
    }


}
