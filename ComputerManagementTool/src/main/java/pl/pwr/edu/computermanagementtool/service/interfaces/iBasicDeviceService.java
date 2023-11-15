package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.BasicDevice;

import java.util.List;

public interface iBasicDeviceService {

    BasicDevice getBasicDeviceById(int id);
    List<BasicDevice> getAllBasicDevices();
    List<BasicDevice> getAllReadyToSellBasicDevices();
    List<BasicDevice> getAllNotReadyToSellBasicDevices();
    List<BasicDevice> getAllBasicDeviceByOfficeId(int officeId);
    BasicDevice addBasicDevice(String deviceName, Float price, String description, Integer age, boolean readyToSell, Integer officeId);
    BasicDevice updateBasicDevice(int id, String deviceName, float price, String description, int age, int officeId);
    BasicDevice setReadyToSell(int basicDeviceId);
    BasicDevice setNotReadyToSell(int basicDeviceId);
    BasicDevice updateLottery(int id, int lotteryId);

}
