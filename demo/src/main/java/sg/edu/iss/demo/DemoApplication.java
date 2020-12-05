package sg.edu.iss.demo;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.demo.car.Car;
import sg.edu.iss.demo.car.CarRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private CarRepository carrepo;
		

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> { 
		     carrepo.save(new Car("Toyota", "Rush", "Silver", "SJB6789H", 2013, 123456));
		     carrepo.save(new Car("Ford", "Mustang", "Black", "SJB6459H", 2015, 123456));
		     carrepo.save(new Car("Honda", "Jazz", "Red", "SEF1234I", 2016, 123456));
		     System.out.println("Reading from database");
		     ArrayList<Car> clist = new ArrayList<Car>();
		     clist = (ArrayList<Car>) carrepo.findAll();
		     for (Iterator<Car> iterator = clist.iterator(); iterator.hasNext();) {
				Car car =  iterator.next();
				System.out.println(car.toString());
			}
		};
	}

}
