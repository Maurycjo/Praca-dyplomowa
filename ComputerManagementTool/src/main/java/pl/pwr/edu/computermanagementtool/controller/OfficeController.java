package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeRepository officeRepository;


    public OfficeController(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/all")
    List<Office> getAllOffices(){

        return officeRepository.findAll();
    }


}
