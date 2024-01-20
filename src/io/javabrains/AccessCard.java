package io.javabrains;
import java.util.Date;

import org.hibernate.annotations.Type;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private Date issuedDate;
    private boolean isActive;
    private String firmwareVersion;
    @OneToOne(mappedBy = "card")
    private Employee owner;

    public Employee getOwner() {
        return owner;
    }
    public void setOwner(Employee owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        return "AccessCard [id=" + id + ", issuedDate=" + issuedDate + ", isActive=" + isActive + ", firmwareVersion="
                + firmwareVersion + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getIssuedDate() {
        return issuedDate;
    }
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getFirmwareVersion() {
        return firmwareVersion;
    }
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
}
