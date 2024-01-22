package io.javabrains;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterUpdate {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        EntityTransaction transaction = entityManager.getTransaction();
        
        Employee employee = entityManager.find(Employee.class, 2);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 153);

        employee.addEmailSubscription(emailGroup);
        emailGroup.addMember(employee);
        
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(emailGroup);
        transaction.commit();
        entityManager.close();
        factory.close();
    }
}