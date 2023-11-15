package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="lottery")
public class Lottery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lottery_date", nullable = false)
    private LocalDate loteryDate;

    @Column(name = "winner_id")
    private Integer winnerId;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getLotteryDate() {
        return loteryDate;
    }

    public void setLotteryDate(LocalDate loteryDate) {
        this.loteryDate = loteryDate;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}