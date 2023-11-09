package employee.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import department.entity.Department;
import employee.entity.Employee;
import employee.service.EmployeeService;

@RestController 
@RequestMapping("/employee")
public class EmployeeController {
	 private static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeeController.class);

	@Autowired  
	EmployeeService employeeService;  
	
	@PostMapping("/save")
    public ResponseEntity<String> saveToPostgres(@RequestBody Employee employee) {
        employeeService.saveToPostgres(employee);
        return ResponseEntity.ok("Data saved to PostgreSQL");
    }

	@GetMapping
    public List<Employee> getAllEmployee() {
        try {
            return employeeService.getAllEmployee();
        } catch (Exception e) {
            logger.error("Error occurred while getting all Employee", e);
            
            return null;
        }
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (Exception e) {
            logger.error("Error occurred while getting employee by ID: " + id, e);
            
            return Optional.empty();
        }
    }
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        try {
            return employeeService.saveEmployee(employee);
        } catch (Exception e) {
            logger.error("Error occurred while saving the employee: " + employee, e);
            
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception e) {
            logger.error("Error occurred while deleting Employee by ID: " + id, e);
           
        }
    }
}
