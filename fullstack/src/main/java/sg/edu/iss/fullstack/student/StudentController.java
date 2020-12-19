package sg.edu.iss.fullstack.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepository srepo;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return srepo.findAll();
	}

	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			Student s = srepo.save(new Student(student.studentId, student.getName(), student.getNickName(), student.getMarks() ));
			return new ResponseEntity<>(s, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		int i = id;
		Optional<Student> sData = srepo.findById(i);
		if (sData.isPresent()) {
			return new ResponseEntity<>(sData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/students/edit/{id}")
	public ResponseEntity<Student> editStudent(@PathVariable("id") int id, @RequestBody Student student) {
		Optional<Student> sData = srepo.findById(id);
		if (sData.isPresent()) {
			Student _student = sData.get();
			_student.setStudentId(student.getStudentId());
			_student.setName(student.getName());
			_student.setNickName(student.getNickName());
			_student.setMarks(student.getMarks());
			return new ResponseEntity<>(srepo.save(_student), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") int id) {
		try {
			srepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/students")
	public ResponseEntity<HttpStatus> deleteAllStudents() {
		try {
			srepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	

}
