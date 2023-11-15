package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.BasicDevice;

import java.util.List;

public interface iBasicDeviceService{


    BasicDevice addBasicDevice(String deviceName, Float price, String description, Integer age, boolean readyToSell, Integer officeId);
    BasicDevice updateBasicDevice(int id, String deviceName, Float price, String description, Integer age, Integer officeId);
    BasicDevice updateLottery(int id, int lotteryId);

}
