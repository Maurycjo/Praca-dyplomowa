package pl.edu.pwr.computermanagementtool.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "other_device")
public class OtherDevice extends DeviceCore{

    public static final String DEVICE_TYPE = "OTHER";
    @Column(name = "additional_info", length = 100)
    private String additionalInfo;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }



}