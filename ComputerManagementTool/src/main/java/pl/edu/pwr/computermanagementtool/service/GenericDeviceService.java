package pl.edu.pwr.computermanagementtool.service;

import pl.edu.pwr.computermanagementtool.entity.DeviceCore;
import pl.edu.pwr.computermanagementtool.entity.Office;
import pl.edu.pwr.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.entity.*;
import pl.edu.pwr.computermanagementtool.repository.GenericDeviceRepository;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public abstract class GenericDeviceService<T extends DeviceCore> {

    protected final GenericDeviceRepository<T> genericDeviceRepository;
    protected final OfficeRepository officeRepository;

    public GenericDeviceService(GenericDeviceRepository<T> genericRepository, OfficeRepository officeRepository) {
        this.genericDeviceRepository = genericRepository;
        this.officeRepository = officeRepository;
    }

    public T getDeviceById(int id) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not found with id: " + id));
    }

    public List<T> getAllDevices() {
        return genericDeviceRepository.findAll();
    }

    public List<T> getAllReadyToLotteryDevices() {
        return genericDeviceRepository.findAllByReadyToLotteryIsTrue();
    }

    public List<T> getAllReadyToLotteryAndOfficeId(int officeId){
        return getAllReadyToLotteryAndOfficeId(officeId);
    }


    public List<T> getAllDeviceByOfficeId(int officeId) {
        return genericDeviceRepository.findAllByOfficeId(officeId);
    }

    public T setReadyToLottery(int basicDeviceId) {

        Optional<T> deviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Device not fount with id: " + basicDeviceId));
        device.setReadyToLottery(true);

        return genericDeviceRepository.save(device);
    }

    public T setNotReadyToLottery(int basicDeviceId) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToLottery(false);

        return genericDeviceRepository.save(basicDevice);
    }

    public T setOrdered(int basicDeviceId) {

        Optional<T> deviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Device not fount with id: " + basicDeviceId));
        device.setOrdered(true);

        return genericDeviceRepository.save(device);
    }

    public T setNotOrdered(int basicDeviceId) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Device not fount with id: " + basicDeviceId));
        basicDevice.setOrdered(false);

        return genericDeviceRepository.save(basicDevice);
    }


    public void deleteDevice(int id){
        genericDeviceRepository.deleteById(id);
    }


    protected DeviceCore addDevice(Class<? extends DeviceCore> deviceClass, String deviceName, Double price, String description, Integer age, String officeAddress) {



        Optional <Office> officeOptional = officeRepository.findOfficeByAddress(officeAddress);
        Office office = officeOptional.orElseThrow(() -> new RuntimeException("Office not found with address: " + officeAddress));

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
        deviceCore.setOffice(office);
        deviceCore.setReadyToLottery(false);
        deviceCore.setOrdered(false);
        deviceCore.setLotteryDate(null);

        return deviceCore;
    }

    //update shared fields of Computer, OtherDevice, Tablet used to help update in these classes
    protected T updateDevice(int id, String deviceName, Double price, String description,
                                   Integer age, String officeAddress){

        Optional<T> deviceOptional = genericDeviceRepository.findById(id);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Device not found with id: " + id));

        if(deviceName!=null)    device.setDeviceName(deviceName);
        if(price!=null)         device.setPrice(price);
        if(description!=null)   device.setDescription(description);
        if(age!=null)           device.setAge(age);


        Optional<Office> officeOptional = officeRepository.findOfficeByAddress(officeAddress);
        Office office = officeOptional.orElseThrow(()-> new RuntimeException("Office not found with address: " + officeAddress));
        device.setOffice(office);

        return device;
    }

    public T setLotteryDateToToday(int deviceId){

        Optional<T> deviceOptional = genericDeviceRepository.findById(deviceId);
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("device not found with id: " + deviceId));
        device.setLotteryDate(LocalDate.now());

        return genericDeviceRepository.save(device);
    }



}
