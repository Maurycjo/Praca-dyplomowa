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

    @Column(name = "lottery_date")
    private LocalDate lotteryDate;

    @Column(name = "min_participant")
    private Integer minParticipant;

    @OneToOne
    @JoinColumn(name = "device_ID")
    private DeviceCore deviceCore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDate getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(LocalDate lotteryDate) {

        try {
            if (lotteryDate.isBefore(LocalDate.now())) {
                throw new RuntimeException("Lottery date can't be before current date!");
            }
            this.lotteryDate = lotteryDate;
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public Integer getMinNumberOfParticipation() {
        return minParticipant;
    }

    public void setMinNumberOfParticipation(Integer minNumberOfParticipation) {
        this.minParticipant = minNumberOfParticipation;
    }

    public Integer getMinParticipant() {
        return minParticipant;
    }

    public void setMinParticipant(Integer minParticipant) {
        this.minParticipant = minParticipant;
    }

    public DeviceCore getDeviceCore() {
        return deviceCore;
    }

    public void setDeviceCore(DeviceCore deviceCore) {
        this.deviceCore = deviceCore;
    }
}