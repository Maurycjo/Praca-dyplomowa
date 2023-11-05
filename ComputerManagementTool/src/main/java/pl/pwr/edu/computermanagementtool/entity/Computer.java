package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "Computer")
public class Computer {
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

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "cpu_id")
    private Integer cpuId;

    @Column(name = "storage_id")
    private Integer storageId;

    @Column(name = "ram_id")
    private Integer ramId;

    @Column(name = "model")
    private String model;

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

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getCpuId() {
        return this.cpuId;
    }

    public void setCpuId(Integer cpuId) {
        this.cpuId = cpuId;
    }

    public Integer getStorageId() {
        return this.storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getRamId() {
        return this.ramId;
    }

    public void setRamId(Integer ramId) {
        this.ramId = ramId;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
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
