package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.repository.GenericDeviceRepository;
import pl.pwr.edu.computermanagementtool.service.DeviceCoreService;

@RestController
@RequestMapping("/devices")
@CrossOrigin(origins = "*")
public class DeviceCoreController extends GenericDeviceController<DeviceCore>{


    protected DeviceCoreController(DeviceCoreService deviceCoreService, GenericDeviceRepository<DeviceCore> genericRepository) {
        super(deviceCoreService, genericRepository);
    }
}














