package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.GenericDeviceService;

import java.util.List;

public abstract class GenericDeviceController<T extends DeviceCore> {

    protected final GenericDeviceService<T> genericDeviceService;
    protected final GenericDeviceRepository<T> genericRepository;

    protected GenericDeviceController(GenericDeviceService<T> genericDeviceService, GenericDeviceRepository<T> genericRepository) {
        this.genericDeviceService = genericDeviceService;
        this.genericRepository = genericRepository;
    }


    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    T getOneBasicDevice(@PathVariable int id){
        return genericDeviceService.getDeviceById(id);
    }


    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    List<T> getAllBasicDevices(){
        return genericDeviceService.getAllDevices();
    }

    @GetMapping("/all-ready-to-lottery")
    @CrossOrigin(origins = "*")
    List<T> getAllReadyToLotteryDevice(){
        return genericDeviceService.getAllReadyToLotteryDevices();
    }
    @GetMapping("/all-ready-to-lottery-by-officeId/{officeId}")
    @CrossOrigin(origins = "*")
    List<T> getAllReadyToLotteryAndOfficeId(@PathVariable int officeId){
        return genericDeviceService.getAllReadyToLotteryAndOfficeId(officeId);
    }
    @GetMapping("/by-office/{officeId}")
    @CrossOrigin(origins = "*")
    List<T> getBasicDevicesByOfficeId(@PathVariable int officeId){
        return genericDeviceService.getAllDeviceByOfficeId(officeId);
    }

    @PutMapping("/set-ready-to-lottery/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> setReadyToLottery(@PathVariable int id){
        try{
            T updatedBasicDevice = genericDeviceService.setReadyToLottery(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/set-not-ready-to-lottery/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> setNotReadyToLottery(@PathVariable int id){
        try{
            T updatedDevice = genericDeviceService.setNotReadyToLottery(id);
            return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/set-ordered/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> setOrdered(@PathVariable int id){
        try{
            T updatedBasicDevice = genericDeviceService.setOrdered(id);
            return new ResponseEntity<>(updatedBasicDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/set-not-ordered/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> setNotOrdered(@PathVariable int id){
        try{
            T updatedDevice = genericDeviceService.setNotOrdered(id);
            return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    void deleteDevice(@PathVariable int id){
        genericDeviceService.deleteDevice(id);
    }


}
