package pl.pwr.edu.computermanagementtool.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.service.implemantation.BasicDeviceService;

import java.util.List;


@RestController
@RequestMapping("/basic-devices")
public class BasicDeviceController {

    private final BasicDeviceService basicDeviceService;

    @Autowired
    public BasicDeviceController(BasicDeviceService basicDeviceService) {
        this.basicDeviceService = basicDeviceService;
    }
    @GetMapping("/{id}")
    BasicDevice getOneBasicDevice(@PathVariable int id){
        return basicDeviceService.getBasicDeviceById(id);
    }
    @GetMapping("/all")
    List<BasicDevice> getAllBasicDevices(){
        return basicDeviceService.getAllBasicDevices();
    }
    @GetMapping("/ready-to-sell")
    List<BasicDevice> getReadyToSellBasicDevices(){
        return basicDeviceService.getAllReadyToSellBasicDevices();
    }
    @GetMapping("/not-ready-to-sell")
    List<BasicDevice> getNotReadyToSellBasicDevices(){
        return basicDeviceService.getAllNotReadyToSellBasicDevices();
    }
    @GetMapping("/by-office/{officeId}")
    List<BasicDevice> getBasicDevicesByOfficeId(@PathVariable int officeId){
        return basicDeviceService.getAllBasicDeviceByOfficeId(officeId);
    }

    @PostMapping("/add")
    public ResponseEntity<BasicDevice> addBasicDevice(
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) boolean readyToSell,
            @RequestParam int officeId){

        try{
            BasicDevice newBasicDevice = basicDeviceService.addBasicDevice(deviceName, price, description, age, readyToSell, officeId);
            return new ResponseEntity<>(newBasicDevice, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BasicDevice> updateBasicDevice(
            @PathVariable int id,
            @RequestParam String deviceName,
            @RequestParam float price,
            @RequestParam String description,
            @RequestParam int age,
            @RequestParam int officeId) {

        try{
            BasicDevice updatedBasicDevice = basicDeviceService.updateBasicDevice(id,deviceName, price, description, age, officeId);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/set-ready-to-sell{id}")
    public ResponseEntity<BasicDevice> setReadyToSell(@PathVariable int id){
        try{
            BasicDevice updatedBasicDevice = basicDeviceService.setReadyToSell(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/set-not-ready-to-sell{id}")
    public ResponseEntity<BasicDevice> setNotReadyToSell(@PathVariable int id){
        try{
            BasicDevice updatedBasicDevice = basicDeviceService.setNotReadyToSell(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
