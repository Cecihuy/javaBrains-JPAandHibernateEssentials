package io.javabrains;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PayStub {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "start")
    private Date payPeriodStart;
    @Column(name = "end")
    private Date payPeriodEnd;
    private float salary;
    @ManyToOne
    @JoinColumn(name = "paystub_for")
    private Employee employee;

    @Override
    public String toString() {
        return "PayStub [id=" + id + ", payPeriodStart=" + payPeriodStart + ", payPeriodEnd=" + payPeriodEnd
                + ", salary=" + salary + ", employee=" + employee + "]";
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getPayPeriodStart() {
        return payPeriodStart;
    }
    public void setPayPeriodStart(Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }
    public Date getPayPeriodEnd() {
        return payPeriodEnd;
    }
    public void setPayPeriodEnd(Date payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
