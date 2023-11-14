package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Office;
import pl.pwr.edu.computermanagementtool.repository.OfficeRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iOfficeService;

import java.util.List;

@Service
public class OfficeService implements iOfficeService{

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office getOfficeById(int id) {
        return null;
    }

    @Override
    public List<Office> getAllOffices() {
        return null;
    }
}
