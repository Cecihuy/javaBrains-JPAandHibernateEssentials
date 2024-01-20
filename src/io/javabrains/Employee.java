package io.javabrains;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employee_data", catalog = "jpa_hibernate_essentials")
public class Employee {
    @Id
    private int id;
    @Column(name = "employee_name")
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }
    public void setType(EmployeeType type) {
        this.type = type;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
