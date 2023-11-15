package pl.pwr.edu.computermanagementtool.service.implemantation;

import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.entity.Office;

import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iBasicDeviceService;


import java.util.List;
import java.util.Optional;

@Service
public class BasicDeviceService extends GenericDeviceService<BasicDevice> {


    public BasicDeviceService(GenericDeviceRepository<BasicDevice> genericDeviceRepository, OfficeRepository officeRepository, LotteryRepository lotteryRepository) {
        super(genericDeviceRepository, officeRepository, lotteryRepository);
    }

    public BasicDevice addBasicDevice(String deviceName, Float price, String description, Integer age, boolean readyToSell, Integer officeId) {
        Optional<Office> officeOptional = officeRepository.findById(officeId);
        Office office = officeOptional.orElseThrow(()->new RuntimeException("Office not found with id: " + officeId));
        BasicDevice basicDevice = new BasicDevice();
        basicDevice.setDeviceName(deviceName);
        basicDevice.setPrice(price);
        basicDevice.setDescription(description);
        basicDevice.setAge(age);
        basicDevice.setReadyToSell(readyToSell);
        basicDevice.setOffice(office);

        return genericDeviceRepository.save(basicDevice);
    }

    public BasicDevice updateBasicDevice(int id, String deviceName, Float price, String description, Integer age, Integer officeId) {

        Optional<BasicDevice> basicDeviceOptional = genericDeviceRepository.findById(id);
        BasicDevice basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + id));
        basicDevice.setDeviceName(deviceName);
        basicDevice.setPrice(price);
        basicDevice.setDescription(description);
        basicDevice.setAge(age);

        if(officeId != null){
            Optional<Office> officeOptional = officeRepository.findById(officeId);
            Office office = officeOptional.orElseThrow(()->new RuntimeException("Office not found with id: "+ officeId));
            basicDevice.setOffice(office);
        }

        return basicDevice;
    }


}
