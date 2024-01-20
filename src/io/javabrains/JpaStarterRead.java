package io.javabrains;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        
        // PayStub payStub = entityManager.find(PayStub.class, 102);
        // System.out.println(payStub.getEmployee());
        System.out.println("**************before fetching employee");
        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println("**************before accessing payStub");
        System.out.println(employee.getPayStub());
    }
}
