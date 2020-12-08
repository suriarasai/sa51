package sg.edu.iss.demo.repo;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.iss.demo.model.Department;

@SpringBootTest
public class QueryTest {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private ParkingSpaceRepository parkingrepo;
	
	@Autowired
	private DepartmentRepository deptrepo;
	
	@Test
	public void departmentTest() {
		System.out.println("Join Finder Example");
		ArrayList<Department> dlist = deptrepo.findAllDepartmentsEmployeeWorksFor("Dilbert");
		for (Iterator<Department> iterator = dlist.iterator(); iterator.hasNext();) {
			Department department = (Department) iterator.next();
			System.out.println(department.toString());
		}
	}

}
