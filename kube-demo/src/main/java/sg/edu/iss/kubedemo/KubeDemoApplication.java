package sg.edu.iss.kubedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KubeDemoApplication {
	
	  @RequestMapping("/hello")
	  public String home() {
	    return "Hello Kubernetes World!!!!";
	  }

	public static void main(String[] args) {
		SpringApplication.run(KubeDemoApplication.class, args);
	}

}
