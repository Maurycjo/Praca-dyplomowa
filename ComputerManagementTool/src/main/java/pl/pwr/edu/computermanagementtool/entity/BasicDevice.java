package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "BasicDevice")
public class BasicDevice {
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
}
