package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DockingStation {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_name", length = 50)
    private String deviceName;

    @Column(name = "price")
    private Double price;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "age", length = 50)
    private String age;

    @Column(name = "ready_to_sell", length = 50)
    private String readyToSell;

    @Column(name = "compatibility_with", length = 50)
    private String compatibilityWith;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getReadyToSell() {
        return readyToSell;
    }

    public void setReadyToSell(String readyToSell) {
        this.readyToSell = readyToSell;
    }

    public String getCompatibilityWith() {
        return compatibilityWith;
    }

    public void setCompatibilityWith(String compatibilityWith) {
        this.compatibilityWith = compatibilityWith;
    }

}