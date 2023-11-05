package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "Ram")
public class Ram {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ram_name")
    private String ramName;

    @Column(name = "ram_price")
    private float ramPrice;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRamName() {
        return this.ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public float getRamPrice() {
        return this.ramPrice;
    }

    public void setRamPrice(float ramPrice) {
        this.ramPrice = ramPrice;
    }
}
