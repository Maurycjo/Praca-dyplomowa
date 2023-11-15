package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;


public interface iDevice<T> {


    public Integer getId();
    public void setId(Integer id);
    public String getDeviceName();
    public void setDeviceName(String deviceName);
    public Float getPrice();
    public void setPrice(Float price);
    public String getDescription();
    public void setDescription(String description);
    public Integer getAge();
    public void setAge(Integer age);
    public Boolean getReadyToSell();
    public void setReadyToSell(Boolean readyToSell);
    public Office getOffice();
    public void setOffice(Office office);
    public Lottery getLottery();
    public void setLottery(Lottery lottery);


}
