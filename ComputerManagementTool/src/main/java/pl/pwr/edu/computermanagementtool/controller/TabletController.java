package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.Tablet;
import pl.pwr.edu.computermanagementtool.repository.TabletRepository;
import pl.pwr.edu.computermanagementtool.service.TabletService;

@RestController
@RequestMapping("/tablet")
public class TabletController  extends GenericDeviceController<Tablet>{

    private final TabletService tabletService;
    private final TabletRepository tabletRepository;
    public TabletController(TabletService tabletService, TabletRepository tabletRepository) {
        super(tabletService, tabletRepository);
        this.tabletService = tabletService;
        this.tabletRepository = tabletRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Tablet> addTablet(
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Boolean readyToSell,
            @RequestParam(required = true) Integer officeId,
            @RequestParam(required = false) String screenSize,
            @RequestParam(required = false) String operatingSystem,
            @RequestParam(required = false) String batteryLife) {

        try {
            Tablet newTablet = tabletService.addTablet(deviceName, price, description, age, readyToSell, officeId,
                                                        screenSize, operatingSystem, batteryLife);
            return new ResponseEntity<>(newTablet, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tablet> updateTablet(
            @PathVariable Integer id,
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Boolean readyToSell,
            @RequestParam(required = true) Integer officeId,
            @RequestParam(required = false) String screenSize,
            @RequestParam(required = false) String operatingSystem,
            @RequestParam(required = false) String batteryLife) {

        try {
            Tablet updatedTablet = tabletService.updateTablet(id, deviceName, price, description, age, readyToSell, officeId,
                    screenSize, operatingSystem, batteryLife);
            return new ResponseEntity<>(updatedTablet, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
