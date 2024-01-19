package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tablet")
public class Tablet extends DeviceCore{

    public static final String DEVICE_TYPE = "TABLET";
    @Column(name = "screen_size", length = 50)
    private String screenSize;

    @Column(name = "operating_system", length = 50)
    private String operatingSystem;

    @Column(name = "battery_life", length = 50)
    private String batteryLife;

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

}