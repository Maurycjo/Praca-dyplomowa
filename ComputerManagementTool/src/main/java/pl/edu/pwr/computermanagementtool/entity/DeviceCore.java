package pl.edu.pwr.computermanagementtool.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "device_core")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DeviceCore {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_type", length = 50)
    private String deviceType;

    @Column(name = "device_name", length = 50)
    private String deviceName;

    @Column(name = "price")
    private Double price;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "age")
    private Integer age;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_ID", nullable = false)
    private Office office;

    @Column(name = "ready_to_lottery")
    private Boolean readyToLottery;
    @Column(name = "lottery_date")
    private LocalDate lotteryDate;

    @Column(name = "is_ordered")
    private Boolean isOrdered;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

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

    public Boolean getReadyToLottery() {
        return readyToLottery;
    }

    public void setReadyToLottery(Boolean readyToLottery) {
        this.readyToLottery = readyToLottery;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public Boolean getOrdered() {
        return isOrdered;
    }

    public void setOrdered(Boolean ordered) {
        isOrdered = ordered;
    }
}