package sg.edu.iss.demo.car;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import sg.edu.iss.demo.model.Department;
import sg.edu.iss.demo.model.Employee;
import sg.edu.iss.demo.model.ParkingSpace;
import sg.edu.iss.demo.repo.DepartmentRepository;
import sg.edu.iss.demo.repo.EmployeeRepository;
import sg.edu.iss.demo.repo.ParkingSpaceRepository;

@SpringBootTest
public class MappingTestsEmployeeParkingSpace {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private ParkingSpaceRepository parkingrepo;
	
	@Autowired
	private DepartmentRepository deptrepo;
	
	@Test
	void employeeParkingCreation() {
		
		Employee emp = new Employee("Dilbert", 3000);
		ParkingSpace ps = new ParkingSpace(1, "29 Heng Mui Keg Terrace");
		Department dept = new Department("IT");
		dept.addEmployee(emp);
		emp.setParkingSpace(ps);
		ps.setEmployee(emp);
		//emprepo.save(emp);
		deptrepo.save(dept);
		
	}
	
	
}
