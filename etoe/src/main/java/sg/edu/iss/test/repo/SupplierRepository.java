package sg.edu.iss.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.test.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
