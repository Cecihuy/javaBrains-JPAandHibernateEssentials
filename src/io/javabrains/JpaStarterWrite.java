package io.javabrains;
import java.util.Date;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterWrite{
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
        card.setOwner(employee);
        employee.setCard(card);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setOwner(employee2);
        employee2.setCard(card2);

        PayStub payStub = new PayStub();
        payStub.setPayPeriodStart(new Date());
        payStub.setPayPeriodEnd(new Date());
        payStub.setEmployee(employee);
        payStub.setSalary(1000);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setEmployee(employee);
        payStub2.setSalary(2000);
        employee.setPayStub(List.of(payStub,payStub2));

        EmailGroup emailGroup = new EmailGroup();
        emailGroup.setName("Company watercooler discussions"); 
        emailGroup.addMember(employee);
        emailGroup.addMember(employee2);
        employee.addEmailSubscription(emailGroup);
        employee2.addEmailSubscription(emailGroup);

        EmailGroup emailGroup2 = new EmailGroup();
        emailGroup2.setName("Engineering");
        employee.addEmailSubscription(emailGroup2);
        emailGroup2.addMember(employee);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(card);
        entityManager.persist(card2);
        entityManager.persist(payStub);
        entityManager.persist(payStub2);
        entityManager.persist(emailGroup);
        entityManager.persist(emailGroup2);
        transaction.commit();
        entityManager.close();
        factory.close();
    }
}