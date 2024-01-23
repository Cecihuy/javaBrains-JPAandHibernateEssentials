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

        TypedQuery<String> typedQuery = entityManager.createQuery(       
            "select e.name from Employee e"
            , String.class
        );
        List<String> resultList = typedQuery.getResultList();
        resultList.forEach(System.out::println);        

        entityManager.close();
        factory.close();
    }
}