package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.GenericDeviceService;

import java.util.List;

public abstract class GenericDeviceController<T extends DeviceCore> {

    protected final GenericDeviceService<T> genericDeviceService;
    protected final GenericDeviceRepository<T> genericRepository;

    protected GenericDeviceController(GenericDeviceService<T> genericDeviceService, GenericDeviceRepository<T> genericRepository) {
        this.genericDeviceService = genericDeviceService;
        this.genericRepository = genericRepository;
    }


    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    T getOneBasicDevice(@PathVariable int id){
        return genericDeviceService.getDeviceById(id);
    }


    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    List<T> getAllBasicDevices(){
        return genericDeviceService.getAllDevices();
    }
    @GetMapping("/ready-to-sell")
    @CrossOrigin(origins = "*")
    List<T> getReadyToSellBasicDevices(){
        return genericDeviceService.getAllReadyToSellDevices();
    }
    @GetMapping("/not-ready-to-sell")
    @CrossOrigin(origins = "*")
    List<T> getNotReadyToSellBasicDevices(){
        return genericDeviceService.getAllNotReadyToSellDevices();
    }
    @GetMapping("/by-office/{officeId}")
    @CrossOrigin(origins = "*")
    List<T> getBasicDevicesByOfficeId(@PathVariable int officeId){
        return genericDeviceService.getAllDeviceByOfficeId(officeId);
    }

    @PutMapping("/set-ready-to-sell/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> setReadyToSell(@PathVariable int id){
        try{
            T updatedBasicDevice = genericDeviceService.setReadyToSell(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/set-not-ready-to-sell/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> setNotReadyToSell(@PathVariable int id){
        try{
            T updatedDevice = genericDeviceService.setNotReadyToSell(id);
            return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    void deleteDevice(@PathVariable int id){
        genericDeviceService.deleteDevice(id);
    }


}
