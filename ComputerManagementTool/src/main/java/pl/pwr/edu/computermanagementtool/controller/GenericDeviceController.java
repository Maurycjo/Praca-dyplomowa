package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.entity.iDevice;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.implemantation.GenericDeviceService;

import java.util.List;


public abstract class GenericDeviceController<T extends iDevice<T>> {

    private final GenericDeviceService<T> genericDeviceService;
    private final GenericDeviceRepository<T> genericDeviceRepository;

    public GenericDeviceController(GenericDeviceService<T> genericDeviceService, GenericDeviceRepository<T> genericDeviceRepository) {
        this.genericDeviceService = genericDeviceService;
        this.genericDeviceRepository = genericDeviceRepository;
    }

    @GetMapping("/{id}")
    T getOneBasicDevice(@PathVariable int id){
        return genericDeviceService.getDeviceById(id);
    }
    @GetMapping("/all")
    List<T> getAllBasicDevices(){
        return genericDeviceService.getAllDevices();
    }
    @GetMapping("/ready-to-sell")
    List<T> getReadyToSellBasicDevices(){
        return genericDeviceService.getAllReadyToSellDevices();
    }
    @GetMapping("/not-ready-to-sell")
    List<T> getNotReadyToSellBasicDevices(){
        return genericDeviceService.getAllNotReadyToSellDevices();
    }
    @GetMapping("/by-office/{officeId}")
    List<T> getBasicDevicesByOfficeId(@PathVariable int officeId){
        return genericDeviceService.getAllDeviceByOfficeId(officeId);
    }
    @PutMapping("/set-ready-to-sell/{id}")
    public ResponseEntity<T> setReadyToSell(@PathVariable int id){
        try{
            T updatedBasicDevice = genericDeviceService.setReadyToSell(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/set-not-ready-to-sell/{id}")
    public ResponseEntity<T> setNotReadyToSell(@PathVariable int id){
        try{
            T updatedDevice = genericDeviceService.setNotReadyToSell(id);
            return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
