package sg.edu.iss.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.demo.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("Select d from Department as d join Employee as e where e.name=:n and d.id=e.department.id")
	public ArrayList<Department> findAllDepartmentsEmployeeWorksFor(@Param("n") String name);
	
	
}
