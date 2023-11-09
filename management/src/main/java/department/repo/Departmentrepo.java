package department.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import department.entity.Department;

public interface Departmentrepo extends JpaRepository <Department ,Integer>{

}
