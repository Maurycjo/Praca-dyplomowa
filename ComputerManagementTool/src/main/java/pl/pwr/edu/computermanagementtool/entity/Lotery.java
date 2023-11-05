package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Lotery")
public class Lotery {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "lotery_date")
    private Date loteryDate;

    @Column(name = "winner_id")
    private Integer winnerId;

    @Column(name = "is_active")
    private Boolean isActive;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLoteryDate() {
        return this.loteryDate;
    }

    public void setLoteryDate(Date loteryDate) {
        this.loteryDate = loteryDate;
    }

    public Integer getWinnerId() {
        return this.winnerId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
