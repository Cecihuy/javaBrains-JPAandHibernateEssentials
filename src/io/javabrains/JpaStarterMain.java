package io.javabrains;
import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterMain{
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Foo Bar");
        employee.setDob(new Date());
        employee.setType(EmployeeType.PERMANENT);

        Employee employee1 = new Employee();
        employee1.setId(2);
        employee1.setName("Bar Baz");
        employee1.setDob(new Date());
        employee1.setType(EmployeeType.FULL_TIME);

        Employee employee2 = new Employee();
        employee2.setId(3);
        employee2.setName("Bax Foo");
        employee2.setDob(new Date());
        employee2.setType(EmployeeType.CONTRACTOR);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityTransaction.commit();
    }
}