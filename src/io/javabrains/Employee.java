package io.javabrains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employee_data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "employee_name")
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    private String ssn;
    private int age;
    @OneToOne
    private AccessCard card;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<PayStub> payStub = new ArrayList<PayStub>();    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMAIL_GROUP-SUBSCRIPTIONS"        
        ,joinColumns = @JoinColumn(name = "EMPLOYEE_ID")
        ,inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTION_EMAIL_ID")
    )
    private List<EmailGroup> emailGroups = new ArrayList<EmailGroup>();

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }
    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }
    public List<PayStub> getPayStub() {
        return payStub;
    }
    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", type=" + type + ", ssn=" + ssn + ", age="
                + age + ", card=" + card + "]";
    }
    public AccessCard getCard() {
        return card;
    }
    public void setCard(AccessCard card) {
        this.card = card;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
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
    public void addEmailSubscription(EmailGroup group){
        this.emailGroups.add(group);
    }
}
