package sg.edu.iss.fullstack.student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByNameContains(String name);

}
