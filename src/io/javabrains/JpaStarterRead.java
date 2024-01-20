package io.javabrains;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        
        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println("******* fetched employee");
        System.out.println(employee.getName());
        System.out.println("******* access card");
        System.out.println(employee.getCard());
    }
}
