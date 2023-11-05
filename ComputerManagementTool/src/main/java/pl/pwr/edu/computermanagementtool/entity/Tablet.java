package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "Tablet")
public class Tablet {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    @Column(name = "age")
    private Integer age;

    @Column(name = "ready_to_sell")
    private Boolean readyToSell;

    @Column(name = "office_ID")
    private Integer officeId;

    @Column(name = "lotery_ID")
    private Integer loteryId;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "batery_life")
    private String bateryLife;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getReadyToSell() {
        return this.readyToSell;
    }

    public void setReadyToSell(Boolean readyToSell) {
        this.readyToSell = readyToSell;
    }

    public Integer getOfficeId() {
        return this.officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getLoteryId() {
        return this.loteryId;
    }

    public void setLoteryId(Integer loteryId) {
        this.loteryId = loteryId;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBateryLife() {
        return this.bateryLife;
    }

    public void setBateryLife(String bateryLife) {
        this.bateryLife = bateryLife;
    }
}
