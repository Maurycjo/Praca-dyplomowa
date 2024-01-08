package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.Tablet;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.repository.TabletRepository;

@Service
public class TabletService extends GenericDeviceService<Tablet>{

    public TabletService(TabletRepository tabletRepository, OfficeRepository officeRepository){
        super(tabletRepository, officeRepository);
    }

    public Tablet addTablet(String deviceName, Double price, String description,
                            Integer age, Boolean readyToSell, Integer officeId,
                            String screenSize, String operatingSystem, String batteryLife){

        Tablet tablet = (Tablet) addDevice(Tablet.class, deviceName, price, description,
                                                                age, readyToSell, officeId);

        tablet.setScreenSize(screenSize);
        tablet.setOperatingSystem(operatingSystem);
        tablet.setDeviceType(Tablet.DEVICE_TYPE);
        tablet.setBatteryLife(batteryLife);

        return genericDeviceRepository.save(tablet);
    }

    public Tablet updateTablet(int id, String deviceName, Double price, String description,
                               Integer age, Boolean readyToSell, Integer officeId,
                               String screenSize, String operatingSystem, String batteryLife) {

        Tablet tablet = updateDevice(id, deviceName, price, description, age, readyToSell, officeId);


        tablet.setScreenSize(screenSize);
        tablet.setOperatingSystem(operatingSystem);
        tablet.setBatteryLife(batteryLife);



        return genericDeviceRepository.save(tablet);
    }


}
