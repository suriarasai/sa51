package sg.edu.iss.demo.car;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.iss.demo.car.Car;
import sg.edu.iss.demo.car.CarRepository;

@SpringBootTest
public class CarRepoTests {

	@Autowired
	private CarRepository carrepo;

	@Test
	void carCreation() {
		carrepo.save(new Car("Toyota", "Rush", "Silver", "SJB6789H", 2013, 23456));
		carrepo.save(new Car("Ford", "Mustang", "Black", "SJB6459H", 2015, 43456));
		carrepo.save(new Car("Honda", "Jazz", "Red", "SEF1234I", 2016, 123456));
	}

	@Test
	void findAllCars() {
		System.out.println("Reading from database");
		System.out.println("FindAll");
		ArrayList<Car> clist = new ArrayList<Car>();
		clist = (ArrayList<Car>) carrepo.findAll();
		for (Iterator<Car> iterator = clist.iterator(); iterator.hasNext();) {
			Car car = iterator.next();
			System.out.println(car.toString());
		}
	}

	@Test
	void findByBrandLike() {
		System.out.println("FindByBrandLike");
		ArrayList<Car> clist1 = new ArrayList<Car>();
		clist1 = (ArrayList<Car>) carrepo.findCarsByBrandLike("T%");
		for (Iterator<Car> iterator = clist1.iterator(); iterator.hasNext();) {
			Car car = iterator.next();
			System.out.println(car.toString());
		}
	}

	@Test
	void findByPriceGreaterThan() {
		System.out.println("FindByPriceGreaterThan");
		ArrayList<Car> clist2 = new ArrayList<Car>();
		clist2 = (ArrayList<Car>) carrepo.findCarsByPriceGreaterThan(100000);
		for (Iterator<Car> iterator = clist2.iterator(); iterator.hasNext();) {
			Car car = iterator.next();
			System.out.println(car.toString());
		}
	}
	
	@Test
	void findCarsByColorAndModelTest() {
		System.out.println("Test the finder method by name findCarsByColorAndModel");
		ArrayList<Car> cist3 = (ArrayList<Car>) carrepo.findCarsByColorAndModel("Silver", "Rush");
		for (Iterator sys = cist3.iterator(); sys.hasNext();) {
			Car car = (Car) sys.next();
			System.out.println("FM3"+car.toString());
		}
	}

}
