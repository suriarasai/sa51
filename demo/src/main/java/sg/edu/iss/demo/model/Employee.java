package sg.edu.iss.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;
    
    @OneToOne(cascade = {CascadeType.ALL})  
    @JoinColumn(name="PSPACE_ID") 
    private ParkingSpace parkingSpace;
    
    @ManyToOne
    private Department department;
    
    @ManyToMany 
    private Collection<Project> projects;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Employee(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, long salary, ParkingSpace parkingSpace, Department department,
			Collection<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.parkingSpace = parkingSpace;
		this.department = department;
		this.projects = projects;
	}

	public Employee(String name, long salary, ParkingSpace parkingSpace, Department department,
			Collection<Project> projects) {
		super();
		this.name = name;
		this.salary = salary;
		this.parkingSpace = parkingSpace;
		this.department = department;
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", parkingSpace=" + parkingSpace
				+ ", department=" + department + "]";
	}

	    
    
}
