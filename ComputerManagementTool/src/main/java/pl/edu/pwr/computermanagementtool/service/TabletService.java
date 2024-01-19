package pl.edu.pwr.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.edu.pwr.computermanagementtool.entity.Tablet;
import pl.edu.pwr.computermanagementtool.repository.OfficeRepository;
import pl.edu.pwr.computermanagementtool.repository.TabletRepository;

@Service
public class TabletService extends GenericDeviceService<Tablet>{

    public TabletService(TabletRepository tabletRepository, OfficeRepository officeRepository){
        super(tabletRepository, officeRepository);
    }

    public Tablet addTablet(String deviceName, Double price, String description,
                            Integer age, String officeAddress,
                            String screenSize, String operatingSystem, String batteryLife){

        Tablet tablet = (Tablet) addDevice(Tablet.class, deviceName, price, description,
                                                                age, officeAddress);

        tablet.setScreenSize(screenSize);
        tablet.setOperatingSystem(operatingSystem);
        tablet.setDeviceType(Tablet.DEVICE_TYPE);
        tablet.setBatteryLife(batteryLife);

        return genericDeviceRepository.save(tablet);
    }

    public Tablet updateTablet(int id, String deviceName, Double price, String description,
                               Integer age, String officeAddress,
                               String screenSize, String operatingSystem, String batteryLife) {

        Tablet tablet = updateDevice(id, deviceName, price, description, age, officeAddress);


        tablet.setScreenSize(screenSize);
        tablet.setOperatingSystem(operatingSystem);
        tablet.setBatteryLife(batteryLife);



        return genericDeviceRepository.save(tablet);
    }


}
