package sg.edu.iss.demo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy="projects")
    private Collection<Employee> employees;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String name, Collection<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}
	public Project(int id, String name, Collection<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
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
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
    
}

