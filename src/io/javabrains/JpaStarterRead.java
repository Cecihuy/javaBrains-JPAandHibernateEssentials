package io.javabrains;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 152);
        System.out.println("Got email group, now accessing members");
        System.out.println(emailGroup.getMembers());
    }
}
