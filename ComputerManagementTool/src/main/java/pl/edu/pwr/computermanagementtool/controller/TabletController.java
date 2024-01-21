package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.computermanagementtool.dto.device.TabletRequestDTO;
import pl.edu.pwr.computermanagementtool.entity.Tablet;
import pl.edu.pwr.computermanagementtool.repository.TabletRepository;
import pl.edu.pwr.computermanagementtool.service.TabletService;

@RestController
@RequestMapping("/tablets")
@CrossOrigin(origins = "*")
public class TabletController  extends GenericDeviceController<Tablet>{

    private final TabletService tabletService;
    private final TabletRepository tabletRepository;
    public TabletController(TabletService tabletService, TabletRepository tabletRepository) {
        super(tabletService, tabletRepository);
        this.tabletService = tabletService;
        this.tabletRepository = tabletRepository;
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Tablet> addTablet(@RequestBody TabletRequestDTO tabletRequestDTO){


        try {
            Tablet newTablet = tabletService.addTablet(
                    tabletRequestDTO.getDeviceName(),
                    tabletRequestDTO.getPrice(),
                    tabletRequestDTO.getDescription(),
                    tabletRequestDTO.getAge(),
                    tabletRequestDTO.getOfficeAddress(),
                    tabletRequestDTO.getScreenSize(),
                    tabletRequestDTO.getOperatingSystem(),
                    tabletRequestDTO.getBatteryLife()

            );
            return new ResponseEntity<>(newTablet, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Tablet> updateTablet(
            @PathVariable Integer id,
            @RequestBody TabletRequestDTO tabletRequestDTO) {

        try {
            Tablet updatedTablet = tabletService.updateTablet(
                    id,
                    tabletRequestDTO.getDeviceName(),
                    tabletRequestDTO.getPrice(),
                    tabletRequestDTO.getDescription(),
                    tabletRequestDTO.getAge(),
                    tabletRequestDTO.getOfficeAddress(),
                    tabletRequestDTO.getScreenSize(),
                    tabletRequestDTO.getOperatingSystem(),
                    tabletRequestDTO.getBatteryLife()
            );
            return new ResponseEntity<>(updatedTablet, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
