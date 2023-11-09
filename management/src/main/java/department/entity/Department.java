package department.entity;

import java.sql.Date;

import employee.entity.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;
	private Date createdAt;
	private Date updatedAt;
	 
    @OneToOne(mappedBy = "Employee", cascade = CascadeType.ALL)
    private Employee employee;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int departmentId, String departmentName, Date createdAt, Date updatedAt, Employee employee) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.employee = employee;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
