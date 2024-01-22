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
            // "select e from Employee e"
            // "select e from Employee e where e.age > 25"
            // "select e from Employee e where e.age between 22 and 32"
            "select e from Employee e where e.name like '%Bar%'"
            , Employee.class
        );
        List<Employee> resultList = typedQuery.getResultList();
        resultList.forEach(System.out::println);        

        entityManager.close();
        factory.close();
    }
}