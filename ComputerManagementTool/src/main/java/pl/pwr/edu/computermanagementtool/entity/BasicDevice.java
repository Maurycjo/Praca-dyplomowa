package pl.pwr.edu.computermanagementtool.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "basic_device")

public class BasicDevice implements iDevice<BasicDevice>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_name", length = 50)
    private String deviceName;

    @Column(name = "price")
    private Float price;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "age")
    private Integer age;

    @Column(name = "ready_to_sell")
    private Boolean readyToSell;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_ID", nullable = false)
    private Office office;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lotery_ID")
    private Lottery lottery;



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

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }


    public BasicDevice() {

    }

    public BasicDevice(String deviceName, Float price, String description, Integer age, Boolean readyToSell, Office office) {
        this.deviceName = deviceName;
        this.price = price;
        this.description = description;
        this.age = age;
        this.readyToSell = readyToSell;
        this.office = office;
    }


}