package pl.edu.pwr.computermanagementtool.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.computermanagementtool.dto.device.ComputerRequestDTO;
import pl.edu.pwr.computermanagementtool.entity.Computer;
import pl.edu.pwr.computermanagementtool.repository.ComputerRepository;
import pl.edu.pwr.computermanagementtool.service.ComputerService;

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
    @CrossOrigin(origins = "*")
    public ResponseEntity<Computer> addComputer(@RequestBody ComputerRequestDTO computerRequestDTO){


        try{
            Computer newComputer = computerService.addComputer(
                    computerRequestDTO.getDeviceName(),
                    computerRequestDTO.getPrice(),
                    computerRequestDTO.getDescription(),
                    computerRequestDTO.getAge(),
                    computerRequestDTO.getOfficeAddress(),
                    computerRequestDTO.getSerialNumber(),
                    computerRequestDTO.getModel(),
                    computerRequestDTO.getOperatingSystem(),
                    computerRequestDTO.getBatteryLife(),
                    computerRequestDTO.getCpuName(),
                    computerRequestDTO.getStorageName(),
                    computerRequestDTO.getRamName()

            );
            return new ResponseEntity<>(newComputer, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Computer> updateComputer(
            @PathVariable Integer id,
            @RequestBody ComputerRequestDTO computerRequestDTO){

        try{
            Computer updatedComputer = computerService.updateComputer(
                    id,
                    computerRequestDTO.getDeviceName(),
                    computerRequestDTO.getPrice(),
                    computerRequestDTO.getDescription(),
                    computerRequestDTO.getAge(),
                    computerRequestDTO.getOfficeAddress(),
                    computerRequestDTO.getSerialNumber(),
                    computerRequestDTO.getModel(),
                    computerRequestDTO.getOperatingSystem(),
                    computerRequestDTO.getBatteryLife(),
                    computerRequestDTO.getCpuName(),
                    computerRequestDTO.getStorageName(),
                    computerRequestDTO.getRamName()

            );
            return new ResponseEntity<>(updatedComputer, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



}
