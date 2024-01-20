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

        Employee employee2 = new Employee();
        employee2.setName("Bar Baz");
        employee2.setSsn("1234");
        employee2.setDob(new Date());
        employee2.setAge(30);
        employee2.setType(EmployeeType.FULL_TIME);

        AccessCard card = new AccessCard();
        card.setIssuedDate(new Date());
        card.setActive(true);
        card.setFirmwareVersion("1.0.0");
        employee.setCard(card);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        employee2.setCard(card2);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(card);
        entityManager.persist(card2);
        transaction.commit();
        entityManager.close();
        factory.close();
    }
}