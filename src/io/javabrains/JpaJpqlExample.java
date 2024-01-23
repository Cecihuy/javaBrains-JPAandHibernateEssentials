package io.javabrains;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaJpqlExample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = factory.createEntityManager();

        TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("emp_name_asc", Employee.class);
        namedQuery.setParameter("age", 25);

        List<Employee> resultList = namedQuery.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        factory.close();
    }
}