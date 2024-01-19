package pl.edu.pwr.computermanagementtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}