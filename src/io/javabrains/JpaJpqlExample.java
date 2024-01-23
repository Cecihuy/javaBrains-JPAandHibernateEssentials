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

        String age = "25";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(       
            "select e from Employee e where e.age > :minAge "
            , Employee.class
        );
        int minAgeParse = Integer.parseInt(age);
        typedQuery.setParameter("minAge", minAgeParse);

        List<Employee> resultList = typedQuery.getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
        factory.close();
    }
}