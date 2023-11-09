package employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import department.entity.Department;
import employee.entity.Employee;
import employee.repo.Employeerepo;

@Service  
public class EmployeeService {
	 private static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeeService.class);

	@Autowired  
	Employeerepo employeerepo; 

    public void saveToPostgres(Employee employee) {
       
        employeerepo.save(employee);
    }


    public List<Employee> getAllEmployee() {
        try {
            return employeerepo.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while retrieving all employee", e);
            throw new RuntimeException("Error occurred while retrieving all employee", e);
        }
    }

    public Optional<Employee> getEmployeeById(int id) {
        try {
            return employeerepo.findById(id);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving employee by ID: " + id, e);
            throw new RuntimeException("Error occurred while retrieving employee by ID: " + id, e);
        }
    }

    public Employee saveEmployee(Employee employee) {
        try {
            return employeerepo.save(employee);
        } catch (Exception e) {
            logger.error("Error occurred while saving the employee: " + employee, e);
            throw new RuntimeException("Error occurred while saving the employee: " + employee, e);
        }
    }

    public void deleteEmployee(int id) {
        try {
           employeerepo.deleteById(id);
        } catch (Exception e) {
            logger.error("Error occurred while deleting employee by ID: " + id, e);
            throw new RuntimeException("Error occurred while deleting employee by ID: " + id, e);
        }
    }
	
	
}
