package pl.pwr.edu.computermanagementtool.service;

import pl.pwr.edu.computermanagementtool.entity.*;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public abstract class GenericDeviceService<T extends DeviceCore> {

    protected final GenericDeviceRepository<T> genericDeviceRepository;
    protected final LotteryRepository lotteryRepository;
    protected final OfficeRepository officeRepository;

    public GenericDeviceService(GenericDeviceRepository<T> genericRepository, LotteryRepository lotteryRepository, OfficeRepository officeRepository) {
        this.genericDeviceRepository = genericRepository;
        this.lotteryRepository = lotteryRepository;
        this.officeRepository = officeRepository;
    }

    public T getDeviceById(int id) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not found with id: " + id));
    }

    public List<T> getAllDevices() {
        return genericDeviceRepository.findAll();
    }


    public List<T> getAllReadyToSellDevices() {
        return genericDeviceRepository.findAllByReadyToSellIsTrue();
    }

    public List<T> getAllNotReadyToSellDevices(){
        return genericDeviceRepository.findAllByReadyToSellIsFalse();
    }

    public List<T> getAllDeviceByOfficeId(int officeId) {
        return genericDeviceRepository.findAllByOfficeId(officeId);
    }

    public T setReadyToSell(int basicDeviceId) {

        Optional<T> deviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Device not fount with id: " + basicDeviceId));
        device.setReadyToSell(true);

        return device;
    }

    public T setNotReadyToSell(int basicDeviceId) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToSell(false);

        return basicDevice;
    }

    public void deleteDevice(int id){
        genericDeviceRepository.deleteById(id);
    }


    protected DeviceCore addDevice(Class<? extends DeviceCore> deviceClass, String deviceName, Double price, String description, Integer age, Boolean readyToSell, Integer officeId) {

        if(officeId == null){
            throw new RuntimeException("Office required");
        }
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

    //update shared fields of Computer, OtherDevice, Tablet used to help update in these classes
    protected T updateDevice(int id, String deviceName, Double price, String description,
                                   Integer age, Boolean readyToSell, Integer officeId){

        Optional<T> deviceOptional = genericDeviceRepository.findById(id);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Device not found with id: " + id));

        if(deviceName!=null)    device.setDeviceName(deviceName);
        if(price!=null)         device.setPrice(price);
        if(description!=null)   device.setDescription(description);
        if(age!=null)           device.setAge(age);
        if(readyToSell!=null)   device.setReadyToSell(readyToSell);

        if (officeId != null){
            Optional<Office> officeOptional = officeRepository.findById(officeId);
            Office office = officeOptional.orElseThrow(()-> new RuntimeException("Office not found with id: " + officeId));
            device.setOffice(office);
        }
        return device;
    }



}
