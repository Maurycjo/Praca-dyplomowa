package pl.pwr.edu.computermanagementtool.entity;

import javax.persistence.*;

@Entity
@Table(name = "Storage")
public class Storage {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "storage_name")
    private String storageName;

    @Column(name = "storage_price")
    private float storagePrice;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorageName() {
        return this.storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public float getStoragePrice() {
        return this.storagePrice;
    }

    public void setStoragePrice(float storagePrice) {
        this.storagePrice = storagePrice;
    }
}
