package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "Office")
public class Office {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "adress")
    private String adress;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
