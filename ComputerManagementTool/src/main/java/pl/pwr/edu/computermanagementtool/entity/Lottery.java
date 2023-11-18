package pl.pwr.edu.computermanagementtool.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceCore device;

    @Column(name = "lottery_date")
    private LocalDate lotteryDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeviceCore getDevice() {
        return device;
    }

    public void setDevice(DeviceCore device) {
        this.device = device;
    }

    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}