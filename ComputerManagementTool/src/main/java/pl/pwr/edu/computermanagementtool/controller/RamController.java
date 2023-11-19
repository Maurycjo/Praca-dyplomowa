package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Ram;
import pl.pwr.edu.computermanagementtool.repository.RamRepository;
import pl.pwr.edu.computermanagementtool.service.RamService;

@RestController
@RequestMapping("/rams")
public class RamController extends ComponentController<Ram> {

    private final RamService ramService;
    private final RamRepository ramRepository;

    public RamController(RamService ramService, RamRepository ramRepository) {
        super(ramService, ramRepository);
        this.ramService = ramService;
        this.ramRepository = ramRepository;
    }
}
