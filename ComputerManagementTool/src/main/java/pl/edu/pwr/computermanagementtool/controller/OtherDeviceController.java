package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.computermanagementtool.dto.device.OtherDeviceRequestDTO;
import pl.edu.pwr.computermanagementtool.entity.OtherDevice;
import pl.edu.pwr.computermanagementtool.repository.OtherDeviceRepository;
import pl.edu.pwr.computermanagementtool.service.OtherDeviceService;

@RestController
@RequestMapping("/other-devices")
@CrossOrigin(origins = "*")
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
    public ResponseEntity<OtherDevice> addOtherDevice(@RequestBody OtherDeviceRequestDTO otherDeviceRequestDTO){

        try {

            OtherDevice newOtherDevice = otherDeviceService.addOtherDevice(
                    otherDeviceRequestDTO.getDeviceName(),
                    otherDeviceRequestDTO.getPrice(),
                    otherDeviceRequestDTO.getDescription(),
                    otherDeviceRequestDTO.getAge(),
                    otherDeviceRequestDTO.getOfficeAddress(),
                    otherDeviceRequestDTO.getAdditionalInfo()
            );

            return new ResponseEntity<>(newOtherDevice, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<OtherDevice> updateOtherDevice(
            @PathVariable Integer id,
            @RequestBody OtherDeviceRequestDTO otherDeviceRequestDTO){

       try {

        OtherDevice updatedOtherDevice = otherDeviceService.updateOtherDevice(
                id,
                otherDeviceRequestDTO.getDeviceName(),
                otherDeviceRequestDTO.getPrice(),
                otherDeviceRequestDTO.getDescription(),
                otherDeviceRequestDTO.getAge(),
                otherDeviceRequestDTO.getOfficeAddress(),
                otherDeviceRequestDTO.getAdditionalInfo()
        );

        return new ResponseEntity<>(updatedOtherDevice, HttpStatus.OK);
    } catch (RuntimeException e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    }

}
