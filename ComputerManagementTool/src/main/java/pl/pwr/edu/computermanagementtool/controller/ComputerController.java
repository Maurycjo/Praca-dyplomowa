package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.implemantation.GenericDeviceService;

@RestController
@RequestMapping("/computers")
public class ComputerController extends GenericDeviceController<Computer>{

    public ComputerController(GenericDeviceService<Computer> genericDeviceService, GenericDeviceRepository<Computer> genericDeviceRepository) {
        super(genericDeviceService, genericDeviceRepository);
    }
}
