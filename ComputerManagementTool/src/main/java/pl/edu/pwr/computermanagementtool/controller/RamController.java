package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.computermanagementtool.entity.Ram;
import pl.edu.pwr.computermanagementtool.repository.RamRepository;
import pl.edu.pwr.computermanagementtool.service.RamService;

@RestController
@RequestMapping("/rams")
@CrossOrigin(origins = "*")
public class RamController extends ComponentController<Ram> {

    private final RamService ramService;
    private final RamRepository ramRepository;

    public RamController(RamService ramService, RamRepository ramRepository) {
        super(ramService, ramRepository);
        this.ramService = ramService;
        this.ramRepository = ramRepository;
    }
}
