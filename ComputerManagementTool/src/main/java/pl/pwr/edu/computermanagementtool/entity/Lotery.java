package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Lotery {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lotery_date", nullable = false)
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

    public LocalDate getLoteryDate() {
        return loteryDate;
    }

    public void setLoteryDate(LocalDate loteryDate) {
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