package pl.pwr.edu.computermanagementtool.service.implemantation;

import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public abstract class GenericDeviceService<T extends DeviceCore> {

    protected final GenericDeviceRepository<T> genericRepository;
    protected final LotteryRepository lotteryRepository;
    protected final OfficeRepository officeRepository;

    public GenericDeviceService(GenericDeviceRepository<T> genericRepository, LotteryRepository lotteryRepository, OfficeRepository officeRepository) {
        this.genericRepository = genericRepository;
        this.lotteryRepository = lotteryRepository;
        this.officeRepository = officeRepository;
    }

    public T getDeviceById(int id) {
        Optional<T> basicDeviceOptional = genericRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not found with id: " + id));
    }

    public List<T> getAllDevices() {
        return genericRepository.findAll();
    }


    public List<T> getAllReadyToSellDevices() {
        return genericRepository.findAllByReadyToSellIsTrue();
    }

    public List<T> getAllNotReadyToSellDevices(){
        return genericRepository.findAllByReadyToSellIsFalse();
    }

    public List<T> getAllDeviceByOfficeId(int officeId) {
        return genericRepository.findAllByOfficeId(officeId);
    }

    public T setReadyToSell(int basicDeviceId) {

        Optional<T> deviceOptional = genericRepository.findById(basicDeviceId);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        device.setReadyToSell(true);

        return device;
    }

    public T setNotReadyToSell(int basicDeviceId) {
        Optional<T> basicDeviceOptional = genericRepository.findById(basicDeviceId);
        T basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToSell(false);

        return basicDevice;
    }


    protected DeviceCore addDevice(Class<? extends DeviceCore> deviceClass, String deviceName, Double price, String description, Integer age, Boolean readyToSell, Integer officeId) {
        Optional<Office> officeOptional = officeRepository.findById(officeId);
        Office office = officeOptional.orElseThrow(() -> new RuntimeException("Office not found with id: " + officeId));

        DeviceCore deviceCore;
        try {
            deviceCore = deviceClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error creating device", e);
        }

        deviceCore.setDeviceName(deviceName);
        deviceCore.setPrice(price);
        deviceCore.setDescription(description);
        deviceCore.setAge(age);
        deviceCore.setReadyToSell(readyToSell);
        deviceCore.setOffice(office);

        return deviceCore;
    }

}
