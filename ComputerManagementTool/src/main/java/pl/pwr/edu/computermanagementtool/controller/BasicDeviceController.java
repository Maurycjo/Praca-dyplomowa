package pl.pwr.edu.computermanagementtool.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.implemantation.BasicDeviceService;
import pl.pwr.edu.computermanagementtool.service.implemantation.GenericDeviceService;

import java.util.List;


@RestController
@RequestMapping("/basic-devices")
public class BasicDeviceController extends GenericDeviceController<BasicDevice> {


    public BasicDeviceController(GenericDeviceService<BasicDevice> genericDeviceService, GenericDeviceRepository<BasicDevice> genericDeviceRepository) {
        super(genericDeviceService, genericDeviceRepository);
    }

//    @PostMapping("/add")
//    public ResponseEntity<BasicDevice> addBasicDevice(
//            @RequestParam(required = false) String deviceName,
//            @RequestParam(required = false) Float price,
//            @RequestParam(required = false) String description,
//            @RequestParam(required = false) Integer age,
//            @RequestParam(required = false) boolean readyToSell,
//            @RequestParam Integer officeId){
//
//        try{
//            BasicDevice newBasicDevice = basicDeviceService.addBasicDevice(deviceName, price, description, age, readyToSell, officeId);
//            return new ResponseEntity<>(newBasicDevice, HttpStatus.CREATED);
//        } catch (RuntimeException e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<BasicDevice> updateBasicDevice(
//            @PathVariable Integer id,
//            @RequestParam(required = false) String deviceName,
//            @RequestParam(required = false) Float price,
//            @RequestParam(required = false) String description,
//            @RequestParam(required = false) Integer age,
//            @RequestParam(required = false) Integer officeId) {
//
//        try{
//            BasicDevice updatedBasicDevice = basicDeviceService.updateBasicDevice(id,deviceName, price, description, age, officeId);
//            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
//        } catch(RuntimeException e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
