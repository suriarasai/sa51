package sg.edu.iss.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
