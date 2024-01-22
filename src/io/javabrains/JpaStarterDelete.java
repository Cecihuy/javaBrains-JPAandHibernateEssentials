package io.javabrains;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaStarterDelete {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        EntityTransaction transaction = entityManager.getTransaction();
        
        Employee employee = entityManager.find(Employee.class, 1);
        
        transaction.begin();
        entityManager.remove(employee);;
        transaction.commit();
        entityManager.close();
        factory.close();
    }
}