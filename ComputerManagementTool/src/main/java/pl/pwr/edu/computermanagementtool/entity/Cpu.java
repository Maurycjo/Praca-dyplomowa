package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cpu")
public class Cpu {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cpu_name", nullable = false, length = 50)
    private String cpuName;

    @Column(name = "cpu_price")
    private Double cpuPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public Double getCpuPrice() {
        return cpuPrice;
    }

    public void setCpuPrice(Double cpuPrice) {
        this.cpuPrice = cpuPrice;
    }

}