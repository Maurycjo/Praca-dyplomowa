package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.OtherDevice;
import pl.pwr.edu.computermanagementtool.repository.OtherDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.OtherDeviceService;

@RestController
@RequestMapping("/other-devices")
public class OtherDeviceController extends GenericDeviceController<OtherDevice> {

    private final OtherDeviceService otherDeviceService;
    private final OtherDeviceRepository otherDeviceRepository;

    public OtherDeviceController(OtherDeviceService otherDeviceService, OtherDeviceRepository otherDeviceRepository) {
        super(otherDeviceService, otherDeviceRepository);
        this.otherDeviceService = otherDeviceService;
        this.otherDeviceRepository = otherDeviceRepository;
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public ResponseEntity<OtherDevice> addOtherDevice(
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Boolean readyToSell,
            @RequestParam(required = true) Integer officeId,
            @RequestParam(required = false) String additionalInfo){

        try {
            OtherDevice newOtherDevice = otherDeviceService.addOtherDevice(deviceName, price, description, age, readyToSell, officeId, additionalInfo);
            return new ResponseEntity<>(newOtherDevice, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<OtherDevice> updateOtherDevice(
            @PathVariable Integer id,
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Boolean readyToSell,
            @RequestParam(required = false) Integer officeId,
            @RequestParam(required = false) String additionalInfo){

        try{
            OtherDevice updatedOtherDevice = otherDeviceService.updateOtherDevice(id, deviceName, price, description, age,
                                                                                        readyToSell, officeId, additionalInfo);
            return new ResponseEntity<>(updatedOtherDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
