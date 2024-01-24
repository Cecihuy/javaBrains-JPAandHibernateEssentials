package io.javabrains.springbootjpaexample;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.javabrains.springbootjpaexample.models.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

@SpringBootApplication
public class SpringbootjpaexampleApplication {
	@PersistenceContext
	private EntityManager entityManager;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaexampleApplication.class, args);
	}
	@PostConstruct
	public void start(){
		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println(employee);
	}
}