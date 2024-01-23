package io.javabrains.springbootjpaexample;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "emailGroups")
    private List<Employee> members = new ArrayList<Employee>();

    @Override
    public String toString() {
        return "EmailGroup [id=" + id + ", name=" + name + ", members=" + members + "]";
    }
    public List<Employee> getMembers() {
        return members;
    }
    public void setMembers(List<Employee> members) {
        this.members = members;
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
    public void addMember(Employee employee){
        this.members.add(employee);
    }
}