package sg.edu.iss.fullstack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.fullstack.student.Student;
import sg.edu.iss.fullstack.student.StudentRepository;

@SpringBootApplication
public class FullstackApplication {
	
	@Autowired
	StudentRepository srepo;

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}
    
	
	@Bean
	CommandLineRunner runner() {
		return args -> { 
			Student s1 = new Student("S1", "Justin", "Surprised", 100);
			srepo.save(s1);
			Student s2 = new Student("S2", "Sankalp", "Sweetie", 100);
			srepo.save(s2);
			Student s3 = new Student("S3", "Yanjun", "Theory", 100);
			srepo.save(s3);
			};
	}
}
