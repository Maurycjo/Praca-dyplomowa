package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.repository.DeviceCoreRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iDeviceCoreService;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceCoreService implements iDeviceCoreService {

    protected final DeviceCoreRepository deviceCoreRepository;
    protected final LotteryRepository lotteryRepository;
    protected final OfficeRepository officeRepository;

    public DeviceCoreService(DeviceCoreRepository deviceCoreRepository, LotteryRepository lotteryRepository, OfficeRepository officeRepository) {
        this.deviceCoreRepository = deviceCoreRepository;
        this.lotteryRepository = lotteryRepository;
        this.officeRepository = officeRepository;
    }

    public DeviceCore getDeviceById(int id) {
        Optional<DeviceCore> basicDeviceOptional = deviceCoreRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not found with id: " + id));
    }

    public List<DeviceCore> getAllDevices() {
        return deviceCoreRepository.findAll();
    }


    public List<DeviceCore> getAllReadyToSellDevices() {
        return deviceCoreRepository.findAllByReadyToSellIsTrue();
    }

    public List<DeviceCore> getAllNotReadyToSellDevices(){
        return deviceCoreRepository.findAllByReadyToSellIsFalse();
    }

    public List<DeviceCore> getAllDeviceByOfficeId(int officeId) {
        return deviceCoreRepository.findAllByOfficeId(officeId);
    }

    public DeviceCore setReadyToSell(int basicDeviceId) {

        Optional<DeviceCore> deviceOptional = deviceCoreRepository.findById(basicDeviceId);
        DeviceCore device = deviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        device.setReadyToSell(true);

        return device;
    }

    public DeviceCore setNotReadyToSell(int basicDeviceId) {
        Optional<DeviceCore> basicDeviceOptional = deviceCoreRepository.findById(basicDeviceId);
        DeviceCore basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToSell(false);

        return basicDevice;
    }



}
