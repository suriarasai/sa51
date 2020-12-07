package sg.edu.iss.demo.car;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Long> {
    
	public ArrayList<Car> findCarsByBrandLike(String s);
	public ArrayList<Car> findCarsByPriceGreaterThan(int p);
	
	@Query("Select c from Car as c where c.color=:clr or c.model=:mdl")
	public ArrayList<Car> findCarsByColorAndModel(@Param("clr") String color, @Param("mdl") String model);
	
}
