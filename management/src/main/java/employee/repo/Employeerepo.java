package employee.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import employee.entity.Employee;

public interface Employeerepo  extends JpaRepository<Employee,Integer>{

}
