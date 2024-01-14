package pl.pwr.edu.computermanagementtool.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.repository.ComputerRepository;
import pl.pwr.edu.computermanagementtool.service.ComputerService;

@RestController
@RequestMapping("/computers")
@CrossOrigin(origins = "*")
public class ComputerController extends GenericDeviceController<Computer>{

    private final ComputerService computerService;
    private final ComputerRepository computerRepository;
    public ComputerController(ComputerService computerService, ComputerRepository computerRepository) {
        super(computerService, computerRepository);
        this.computerService = computerService;
        this.computerRepository = computerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Computer> addComputer(
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = true) String officeAddress,
            @RequestParam(required = false) String serialNumber,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String operatingSystem,
            @RequestParam(required = false) String batteryLife,
            @RequestParam(required = false) String cpuName,
            @RequestParam(required = false) String storageName,
            @RequestParam(required = false) String ramName){

        try{
            Computer newComputer = computerService.addComputer(deviceName, price, description, age,
                    officeAddress, serialNumber, model, operatingSystem,
                                                                                batteryLife, cpuName, storageName, ramName);
            return new ResponseEntity<>(newComputer, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Computer> updateComputer(
                                                @PathVariable Integer id,
                                                @RequestParam(required = false) String deviceName,
                                                @RequestParam(required = false) Double price,
                                                @RequestParam(required = false) String description,
                                                @RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String officeAddress,
                                                @RequestParam(required = false) String serialNumber,
                                                @RequestParam(required = false) String model,
                                                @RequestParam(required = false) String operatingSystem,
                                                @RequestParam(required = false) String batteryLife,
                                                @RequestParam(required = false) String cpuName,
                                                @RequestParam(required = false) String storageName,
                                                @RequestParam(required = false) String ramName){

        try{
            Computer updatedComputer = computerService.updateComputer(id, deviceName, price, description, age,
                    officeAddress, serialNumber, model, operatingSystem,
                    batteryLife, cpuName, storageName, ramName);
            return new ResponseEntity<>(updatedComputer, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



}
