package io.javabrains.springbootjpaexample;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.javabrains.springbootjpaexample.models.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;

@SpringBootApplication
public class SpringbootjpaexampleApplication {
	@PersistenceUnit
	private EntityManagerFactory emf;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaexampleApplication.class, args);
	}
	@PostConstruct
	public void start(){
		Employee employee = new Employee();
		employee.setAge(20);
		employee.setName("Foo Bar");
		employee.setSsn("1234");
		employee.setDob(new Date());

		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
		entityManager.close();
	}
}