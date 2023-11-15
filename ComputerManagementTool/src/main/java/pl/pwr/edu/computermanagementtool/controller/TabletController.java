package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Tablet;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.implemantation.GenericDeviceService;

@RestController
@RequestMapping("/tablets")
public class TabletController extends GenericDeviceController<Tablet>{

    public TabletController(GenericDeviceService<Tablet> genericDeviceService, GenericDeviceRepository<Tablet> genericDeviceRepository) {
        super(genericDeviceService, genericDeviceRepository);
    }
}
