package pl.pwr.edu.computermanagementtool.service.implemantation;

import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.repository.BasicDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iBasicDeviceService;


import java.util.List;
import java.util.Optional;

@Service
public class BasicDeviceService implements iBasicDeviceService {

    private final BasicDeviceRepository basicDeviceRepository;

    public BasicDeviceService(BasicDeviceRepository basicDeviceRepository) {
        this.basicDeviceRepository = basicDeviceRepository;
    }

    @Override
    public BasicDevice getBasicDeviceById(int id) {
        Optional<BasicDevice> basicDeviceOptional = basicDeviceRepository.findById(id);
        return basicDeviceOptional.orElseThrow(()-> new RuntimeException("Basic Device not found with id: " + id));
    }

    @Override
    public List<BasicDevice> getAllBasicDevices() {
        return basicDeviceRepository.findAll();
    }
}
