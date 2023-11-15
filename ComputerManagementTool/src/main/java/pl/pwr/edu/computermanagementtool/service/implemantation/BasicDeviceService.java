package pl.pwr.edu.computermanagementtool.service.implemantation;

import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.repository.BasicDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iBasicDeviceService;


import java.util.List;
import java.util.Optional;

@Service
public class BasicDeviceService implements iBasicDeviceService {

    private final BasicDeviceRepository basicDeviceRepository;
    private final OfficeRepository officeRepository;
    private final LotteryRepository lotteryRepository;

    public BasicDeviceService(BasicDeviceRepository basicDeviceRepository, OfficeRepository officeRepository, LotteryRepository lotteryRepository) {
        this.basicDeviceRepository = basicDeviceRepository;
        this.officeRepository = officeRepository;
        this.lotteryRepository = lotteryRepository;
    }


    @Override
    public BasicDevice getBasicDeviceById(int id) {
        Optional<BasicDevice> basicDeviceOptional = basicDeviceRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic Device not found with id: " + id));
    }
    @Override
    public List<BasicDevice> getAllBasicDevices() {
        return basicDeviceRepository.findAll();
    }

    @Override
    public List<BasicDevice> getAllReadyToSellBasicDevices() {
        return basicDeviceRepository.findAllByReadyToSellIsTrue();
    }

    @Override
    public List<BasicDevice> getAllNotReadyToSellBasicDevices(){
        return basicDeviceRepository.findAllByReadyToSellIsFalse();
    }

    @Override
    public List<BasicDevice> getAllBasicDeviceByOfficeId(int officeId) {
        return basicDeviceRepository.findAllByOfficeId(officeId);
    }

    @Override
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


        return basicDeviceRepository.save(basicDevice);
    }

    @Override
    public BasicDevice setReadyToSell(int basicDeviceId) {

        Optional<BasicDevice> basicDeviceOptional = basicDeviceRepository.findById(basicDeviceId);
        BasicDevice basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToSell(true);

        return basicDevice;
    }

    @Override
    public BasicDevice setNotReadyToSell(int basicDeviceId) {
        Optional<BasicDevice> basicDeviceOptional = basicDeviceRepository.findById(basicDeviceId);
        BasicDevice basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToSell(false);

        return basicDevice;
    }

    @Override
    public BasicDevice updateBasicDevice(int id, String deviceName, float price, String description, int age, int officeId) {

        Optional<BasicDevice> basicDeviceOptional = basicDeviceRepository.findById(id);
        BasicDevice basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + id));
        basicDevice.setDeviceName(deviceName);
        basicDevice.setPrice(price);
        basicDevice.setDescription(description);
        basicDevice.setAge(age);

        Optional<Office> officeOptional = officeRepository.findById(officeId);
        Office office = officeOptional.orElseThrow(()->new RuntimeException("Office not found with id: "+ officeId));
        basicDevice.setOffice(office);

        return basicDevice;
    }

    @Override
    public BasicDevice updateLottery(int id, int lotteryId){

        Optional<BasicDevice> basicDeviceOptional = basicDeviceRepository.findById(id);
        BasicDevice basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not found with id: "+id));
        Optional<Lottery> lotteryOptional = lotteryRepository.findById(lotteryId);
        Lottery lottery = lotteryOptional.orElseThrow(()-> new RuntimeException("Lottery not found with id: "+lotteryId));
        basicDevice.setLottery(lottery);

        return basicDevice;

    }

}
