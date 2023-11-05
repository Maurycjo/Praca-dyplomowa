package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ram {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ram_name", nullable = false, length = 50)
    private String ramName;

    @Column(name = "ram_price")
    private Double ramPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public Double getRamPrice() {
        return ramPrice;
    }

    public void setRamPrice(Double ramPrice) {
        this.ramPrice = ramPrice;
    }

}