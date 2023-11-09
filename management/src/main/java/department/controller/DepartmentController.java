package department.controller;

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
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import department.entity.Department;
import department.service.DpartmentService;

@RestController  
public class DepartmentController {
	 private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired  
	DpartmentService departmentservice;  
	@PostMapping("/savemongo")
    public ResponseEntity<String> saveToPostgres(@RequestBody Department department) {
        departmentservice.saveToMongo(department);
        return ResponseEntity.ok("Data saved to mongodb");
    }

	
    @GetMapping
    public List<Department> getAllDepartment() {
        try {
            return departmentservice.getAllDepartment();
        } catch (Exception e) {
            logger.error("Error occurred while getting all department", e);
            
            return null;
        }
    }
    @GetMapping("/{departmentId}")
    public Optional<Department> getDepartmentById(@PathVariable int departmentId) {
        try {
            return departmentservice.getDepartmentById(departmentId);
        } catch (Exception e) {
            logger.error("Error occurred while getting department by ID: " + departmentId, e);
            
            return Optional.empty();
        }
    }
    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        try {
            return departmentservice.saveDepartment(department);
        } catch (Exception e) {
            logger.error("Error occurred while saving the department: " + department, e);
            
            return null;
        }
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable int departmentId) {
        try {
            departmentservice.deleteDepartment(departmentId);
        } catch (Exception e) {
            logger.error("Error occurred while deleting depeartment by ID: " + departmentId, e);
           
        }
    }
}
