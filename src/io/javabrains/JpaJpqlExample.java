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

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(       
            "select e.name, e.age, e.dob from Employee e"
            , Object[].class
        );
        List<Object[]> resultList = typedQuery.getResultList();
        resultList.forEach(e -> System.out.println(e[0] + " " + e[1] + " " + e[2]));        

        entityManager.close();
        factory.close();
    }
}