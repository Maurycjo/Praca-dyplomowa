package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.computermanagementtool.entity.DeviceCore;
import pl.edu.pwr.computermanagementtool.repository.GenericDeviceRepository;
import pl.edu.pwr.computermanagementtool.service.DeviceCoreService;

@RestController
@RequestMapping("/devices")
@CrossOrigin(origins = "*")
public class DeviceCoreController extends GenericDeviceController<DeviceCore>{


    protected DeviceCoreController(DeviceCoreService deviceCoreService, GenericDeviceRepository<DeviceCore> genericRepository) {
        super(deviceCoreService, genericRepository);
    }
}














