package department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import department.entity.Department;
import department.repo.Departmentrepo;

@Service  
public class DpartmentService {
	
	 private static final Logger  logger = (Logger) LoggerFactory.getLogger(DpartmentService.class);

	@Autowired  
	Departmentrepo departmentrepo;
	 public void saveToMongo(Department department) {
	       
	        departmentrepo.save(department);
	    }
	
	public List<Department> getAllDepartment() {
        try {
            return departmentrepo.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while retrieving all department", e);
            throw new RuntimeException("Error occurred while retrieving all department", e);
        }
    }

    public Optional<Department> getDepartmentById(int departmentId) {
        try {
            return departmentrepo.findById(departmentId);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving department by ID: " + departmentId, e);
            throw new RuntimeException("Error occurred while retrieving department by ID: " + departmentId, e);
        }
    }

    public Department saveDepartment(Department department) {
        try {
            return departmentrepo.save(department);
        } catch (Exception e) {
            logger.error("Error occurred while saving the departmentinfo: " + department, e);
            throw new RuntimeException("Error occurred while saving the departmentinfo: " + department, e);
        }
    }

    public void deleteDepartment(int departmentId) {
        try {
            departmentrepo.deleteById(departmentId);
        } catch (Exception e) {
            logger.error("Error occurred while deleting department by ID: " + departmentId, e);
            throw new RuntimeException("Error occurred while deleting book by ID: " + departmentId, e);
        }
    }
	
	
}
