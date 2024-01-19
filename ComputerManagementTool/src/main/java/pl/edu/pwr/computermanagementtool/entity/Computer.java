package pl.edu.pwr.computermanagementtool.entity;

import jakarta.persistence.*;

//@DiscriminatorValue("COMPUTER")
@Entity
@Table(name = "computer")
public class Computer extends DeviceCore{

    public static final String DEVICE_TYPE = "COMPUTER";
    @Column(name = "serial_number", length = 50)
    private String serialNumber;

    @Column(name = "operating_system", length = 50)
    private String operatingSystem;

    @Column(name = "battery_life", length = 50)
    private String batteryLife;

    @Column(name = "model", length = 50)
    private String model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cpu_id")
    private Cpu cpu;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ram_id")
    private Ram ram;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public void setBatteryLife(String bateryLife) {
        this.batteryLife = bateryLife;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

}