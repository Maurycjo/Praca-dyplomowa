package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "storage_name", nullable = false, length = 50)
    private String storageName;

    @Column(name = "storage_price")
    private Double storagePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Double getStoragePrice() {
        return storagePrice;
    }

    public void setStoragePrice(Double storagePrice) {
        this.storagePrice = storagePrice;
    }

}