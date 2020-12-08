package sg.edu.iss.demo.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.iss.demo.model.Department;
import sg.edu.iss.demo.model.Employee;
import sg.edu.iss.demo.model.ParkingSpace;

@SpringBootTest
public class AssociationMappingTests {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private ParkingSpaceRepository parkingrepo;
	
	@Autowired
	private DepartmentRepository deptrepo;
	
	@Autowired
	private ProjectRepository projectrepo;
	
	
	@Test
	public void testAssociation() {
		Department department = new Department("IT");
		Employee employee = new Employee("Dilbert", 3000);
		ParkingSpace parkingSpace = new ParkingSpace(1,"29 Heng Mui Keng Terrace");
		parkingSpace.setEmployee(employee);
		employee.setParkingSpace(parkingSpace);
		department.addEmployee(employee);
		deptrepo.save(department);
		employee.setDepartment(department);
		emprepo.save(employee);
		
	}
	

}
