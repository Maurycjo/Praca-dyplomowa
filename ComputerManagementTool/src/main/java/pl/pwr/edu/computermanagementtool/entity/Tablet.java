package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tablet")
public class Tablet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "ready_to_sell")
    private Boolean readyToSell;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_ID", nullable = false)
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lotery_ID")
    private Lottery lottery;

    @Column(name = "screen_size", length = 50)
    private String screenSize;

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

    public Lottery getLotery() {
        return lottery;
    }

    public void setLotery(Lottery lottery) {
        this.lottery = lottery;
    }

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

    public String getBateryLife() {
        return bateryLife;
    }

    public void setBateryLife(String bateryLife) {
        this.bateryLife = bateryLife;
    }

}