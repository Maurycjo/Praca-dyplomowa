package pl.pwr.edu.computermanagementtool.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private Computer device;

    @Column(name = "lottery_date")
    private LocalDate lotteryDate;

    @Column(name = "lottery_date_min")
    private LocalDate lotteryDateMin;

    @Column(name = "lottery_date_max")
    private LocalDate lotteryDateMax;

    @Column(name = "min_participant")
    private Integer minParticipant;

    @Column(name ="lottery_days_after_min")
    private Integer lotteryDaysAfterMin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Computer getDevice() {
        return device;
    }

    public void setDevice(Computer device) {
        this.device = device;
    }

    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public LocalDate getLotteryDateMin() {
        return lotteryDateMin;
    }

    public void setLotteryDateMin(LocalDate lotteryDateMin) {
        this.lotteryDateMin = lotteryDateMin;
    }

    public LocalDate getLotteryDateMax() {
        return lotteryDateMax;
    }

    public void setLotteryDateMax(LocalDate lotteryDateMax) {
        this.lotteryDateMax = lotteryDateMax;
    }

    public Integer getMinNumberOfParticipation() {
        return minParticipant;
    }

    public void setMinNumberOfParticipation(Integer minNumberOfParticipation) {
        this.minParticipant = minNumberOfParticipation;
    }

    public Integer getLotteryDaysAfterMin() {
        return lotteryDaysAfterMin;
    }

    public void setLotteryDaysAfterMin(Integer lotteryDaysAfterMin) {
        this.lotteryDaysAfterMin = lotteryDaysAfterMin;
    }
}