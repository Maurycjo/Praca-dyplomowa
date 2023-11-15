package pl.pwr.edu.computermanagementtool.service.implemantation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.entity.iDevice;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iGenericDeviceService;

import java.util.List;
import java.util.Optional;


public abstract class GenericDeviceService<T extends iDevice> {

    protected final GenericDeviceRepository<T> genericDeviceRepository;
    protected final OfficeRepository officeRepository;
    protected final LotteryRepository lotteryRepository;

    public GenericDeviceService(GenericDeviceRepository<T> genericDeviceRepository, OfficeRepository officeRepository, LotteryRepository lotteryRepository) {
        this.genericDeviceRepository = genericDeviceRepository;
        this.officeRepository = officeRepository;
        this.lotteryRepository = lotteryRepository;
    }

    public T getDeviceById(int id) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic Device not found with id: " + id));
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
        T device = deviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        device.setReadyToSell(true);

        return device;
    }

    public T setNotReadyToSell(int basicDeviceId) {
        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(basicDeviceId);
        T basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not fount with id: " + basicDeviceId));
        basicDevice.setReadyToSell(false);

        return basicDevice;
    }

    public T updateLottery(int id, int lotteryId){

        Optional<T> basicDeviceOptional = genericDeviceRepository.findById(id);
        T basicDevice = basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic device not found with id: "+id));
        Optional<Lottery> lotteryOptional = lotteryRepository.findById(lotteryId);
        Lottery lottery = lotteryOptional.orElseThrow(()-> new RuntimeException("Lottery not found with id: "+lotteryId));
        basicDevice.setLottery(lottery);

        return basicDevice;
    }

}
