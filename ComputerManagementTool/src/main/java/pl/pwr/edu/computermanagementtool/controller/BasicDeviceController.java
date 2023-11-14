package pl.pwr.edu.computermanagementtool.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.service.implemantation.BasicDeviceService;

import java.util.List;


@RestController
public class BasicDeviceController {

    private final BasicDeviceService basicDeviceService;

    @Autowired
    public BasicDeviceController(BasicDeviceService basicDeviceService) {
        this.basicDeviceService = basicDeviceService;
    }

    @GetMapping("/basic_device/{id}")
    BasicDevice getOneBasicDevice(@PathVariable int id){
        return basicDeviceService.getBasicDeviceById(id);
    }

    @GetMapping("/basicDevices")
    List<BasicDevice> getAllBasicDevice(){
        return basicDeviceService.getAllBasicDevices();
    }

}
