package pl.pwr.edu.computermanagementtool.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DiscriminatorFormula;


@Entity
@Table(name = "other_device")
public class OtherDevice extends DeviceCore{

    @Column(name = "additional_info", length = 100)
    private String additionalInfo;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }



}