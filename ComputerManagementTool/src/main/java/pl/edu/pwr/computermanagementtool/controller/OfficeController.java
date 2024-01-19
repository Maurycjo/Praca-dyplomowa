package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.computermanagementtool.entity.Office;
import pl.edu.pwr.computermanagementtool.repository.OfficeRepository;

import java.util.List;

@RestController
@RequestMapping("/offices")
@CrossOrigin(origins = "*")
public class OfficeController {

    private final OfficeRepository officeRepository;


    public OfficeController(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }


    @RequestMapping("/all")
    List<Office> getAllOffices(){

        return officeRepository.findAll();
    }


}
