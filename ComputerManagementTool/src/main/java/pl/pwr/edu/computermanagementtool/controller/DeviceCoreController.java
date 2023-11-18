package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.repository.DeviceCoreRepository;
import pl.pwr.edu.computermanagementtool.service.implemantation.DeviceCoreService;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceCoreController {


    private final DeviceCoreService deviceCoreService;
    private final DeviceCoreRepository deviceCoreRepository;

    public DeviceCoreController(DeviceCoreService deviceCoreService, DeviceCoreRepository deviceCoreRepository) {
        this.deviceCoreService = deviceCoreService;
        this.deviceCoreRepository = deviceCoreRepository;
    }

    @GetMapping("/{id}")
    DeviceCore getOneBasicDevice(@PathVariable int id){
        return deviceCoreService.getDeviceById(id);
    }
    @GetMapping("/all")
    List<DeviceCore> getAllBasicDevices(){
        return deviceCoreService.getAllDevices();
    }
    @GetMapping("/ready-to-sell")
    List<DeviceCore> getReadyToSellBasicDevices(){
        return deviceCoreService.getAllReadyToSellDevices();
    }
    @GetMapping("/not-ready-to-sell")
    List<DeviceCore> getNotReadyToSellBasicDevices(){
        return deviceCoreService.getAllNotReadyToSellDevices();
    }
    @GetMapping("/by-office/{officeId}")
    List<DeviceCore> getBasicDevicesByOfficeId(@PathVariable int officeId){
        return deviceCoreService.getAllDeviceByOfficeId(officeId);
    }
    @PutMapping("/set-ready-to-sell/{id}")
    public ResponseEntity<DeviceCore> setReadyToSell(@PathVariable int id){
        try{
            DeviceCore updatedBasicDevice = deviceCoreService.setReadyToSell(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/set-not-ready-to-sell/{id}")
    public ResponseEntity<DeviceCore> setNotReadyToSell(@PathVariable int id){
        try{
            DeviceCore updatedDevice = deviceCoreService.setNotReadyToSell(id);
            return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}














