package pl.pwr.edu.computermanagementtool.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.repository.ComputerRepository;
import pl.pwr.edu.computermanagementtool.service.ComputerService;

@RestController
@RequestMapping("/computers")
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
            @RequestParam(required = false) Boolean readyToSell,
            @RequestParam(required = true) Integer officeId,
            @RequestParam(required = false) String serialNumber,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String operatingSystem,
            @RequestParam(required = false) String batteryLife,
            @RequestParam(required = false) Integer cpuId,
            @RequestParam(required = false) Integer storageId,
            @RequestParam(required = false) Integer ramId){

        try{
            Computer newComputer = computerService.addComputer(deviceName, price, description, age, readyToSell,
                                                                     officeId, serialNumber, model, operatingSystem,
                                                                                batteryLife, cpuId, storageId, ramId);
            return new ResponseEntity<>(newComputer, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


}
