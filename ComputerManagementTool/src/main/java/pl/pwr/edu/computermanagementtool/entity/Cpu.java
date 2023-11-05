package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "Cpu")
public class Cpu {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cpu_name")
    private String cpuName;

    @Column(name = "cpu_price")
    private float cpuPrice;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpuName() {
        return this.cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public float getCpuPrice() {
        return this.cpuPrice;
    }

    public void setCpuPrice(float cpuPrice) {
        this.cpuPrice = cpuPrice;
    }
}
