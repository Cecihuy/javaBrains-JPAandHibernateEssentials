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

        TypedQuery<Employee> typedQuery = entityManager.createQuery(
            /* uncomment one of these lines to try*/
            // "select e from Employee e where e.card.isActive = true"
            "select e from Employee e left join AccessCard a on e.id = a.id where card.isActive = true"
            , Employee.class
        );
        List<Employee> resultList = typedQuery.getResultList();
        resultList.forEach(System.out::println);        

        entityManager.close();
        factory.close();
    }
}