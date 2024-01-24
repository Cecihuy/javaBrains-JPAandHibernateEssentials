package io.javabrains.springbootjpaexample;
import io.javabrains.springbootjpaexample.models.Employee;
import io.javabrains.springbootjpaexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.PostConstruct;
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
	@Transactional(readOnly = true)
	public void start(){
		Optional<Employee> employee = employeeRepository.findById(1);
		if(employee.isPresent()){
			System.out.println(employee.get());
			updateEmployee(employee.get());
		}
	}
	@Transactional(propagation = Propagation.MANDATORY)
	private void updateEmployee(Employee employee) {
		employee.setName("Updated name");
		employeeRepository.save(employee);
	}
}