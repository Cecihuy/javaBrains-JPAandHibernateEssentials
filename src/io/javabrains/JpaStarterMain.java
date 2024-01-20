package io.javabrains;
import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterMain{
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Foo Bar");
        employee.setSsn("123");
        employee.setDob(new Date());
        employee.setAge(20);
        employee.setType(EmployeeType.CONTRACTOR);

        Employee employee1 = new Employee();
        employee1.setName("Bar Baz");
        employee1.setSsn("1234");
        employee1.setDob(new Date());
        employee1.setAge(30);
        employee1.setType(EmployeeType.FULL_TIME);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityTransaction.commit();
    }
}