package sg.edu.iss.fullstack.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository srepo;
	
	@GetMapping
	public List<Student> getStudents() {
		return srepo.findAll();
	}
	
	
}
