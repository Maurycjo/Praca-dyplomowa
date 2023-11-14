package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.BasicDevice;

import java.util.List;

public interface iBasicDeviceService {

    BasicDevice getBasicDeviceById(int id);
    List<BasicDevice> getAllBasicDevices();
}
