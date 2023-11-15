package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.entity.iDevice;

import java.util.List;

public interface iGenericDeviceService<T extends iDevice> {

    T getBasicDeviceById(int id);
    List<T> getAllDevices();
    List<T> getAllReadyToSellDevices();
    List<T> getAllNotReadyToSellDevices();
    List<T> getAllDeviceByOfficeId(int officeId);
    T setReadyToSell(int deviceId);
    T setNotReadyToSell(int deviceId);
    T setLottery(Lottery lottery);
}
