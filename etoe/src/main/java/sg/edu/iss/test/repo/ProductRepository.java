package sg.edu.iss.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.test.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
