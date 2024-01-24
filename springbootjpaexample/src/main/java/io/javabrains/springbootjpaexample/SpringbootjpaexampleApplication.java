package io.javabrains.springbootjpaexample;
import io.javabrains.springbootjpaexample.models.Employee;
import io.javabrains.springbootjpaexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootjpaexampleApplication {
	@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaexampleApplication.class, args);
	}
	@PostConstruct
	public void start(){
		Optional<Employee> employee = employeeRepository.findById(1);
		if(employee.isPresent()){
			System.out.println(employee.get());
			updateEmployee(employee.get());
		}
	}
	@Transactional(rollbackOn = SQLException.class)
	private void updateEmployee(Employee employee) {
		employee.setName("Updated name");
		employeeRepository.save(employee);
	}
}