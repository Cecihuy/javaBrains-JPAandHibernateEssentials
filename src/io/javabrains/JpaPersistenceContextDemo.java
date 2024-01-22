package io.javabrains;
import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaPersistenceContextDemo{
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("new Employee");
        employee.setSsn("12345");
        employee.setDob(new Date());
        employee.setAge(25);
        employee.setType(EmployeeType.FULL_TIME);
        
        System.out.println("******************* Created employee instance");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();        
        EntityTransaction transaction = entityManager.getTransaction();
                
        transaction.begin();
        System.out.println("******************* Starting transaction");
        entityManager.persist(employee);
        System.out.println("******************* After persist method called");
        Employee employeeFound = entityManager.find(Employee.class, 1);
        System.out.println(employee);
        System.out.println(employeeFound);
        System.out.println(employee == employeeFound);
        transaction.commit();
        System.out.println("******************* After transaction closed");
        entityManager.close();
        factory.close();
    }
}