package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;

@Entity
public class Computer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_name", length = 50)
    private String deviceName;

    @Column(name = "price")
    private Double price;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "age")
    private Integer age;

    @Column(name = "ready_to_sell", nullable = false)
    private Boolean readyToSell = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_ID", nullable = false)
    private Office office;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lotery_ID")
    private Lotery lotery;

    @Column(name = "serial_number", length = 50)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpu_id", nullable = false)
    private Cpu cpu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id")
    private Ram ram;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "operating_system", length = 50)
    private String operatingSystem;

    @Column(name = "batery_life", length = 50)
    private String bateryLife;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getReadyToSell() {
        return readyToSell;
    }

    public void setReadyToSell(Boolean readyToSell) {
        this.readyToSell = readyToSell;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Lotery getLotery() {
        return lotery;
    }

    public void setLotery(Lotery lotery) {
        this.lotery = lotery;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBateryLife() {
        return bateryLife;
    }

    public void setBateryLife(String bateryLife) {
        this.bateryLife = bateryLife;
    }

}