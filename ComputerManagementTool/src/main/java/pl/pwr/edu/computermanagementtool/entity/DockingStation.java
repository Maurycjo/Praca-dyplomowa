package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "docking_station")
public class DockingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_name", length = 50)
    private String deviceName;

    @Column(name = "price")
    private Float price;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "age", length = 50)
    private String age;

    @Column(name = "ready_to_sell", length = 50)
    private String readyToSell;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_ID", nullable = false)
    private Office office;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lotery_ID")
    private Lottery lottery;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public String getCompatibilityWith() {
        return compatibilityWith;
    }

    public void setCompatibilityWith(String compatibilityWith) {
        this.compatibilityWith = compatibilityWith;
    }

}