package sg.edu.iss.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.test.model.Product;
import sg.edu.iss.test.repo.ProductRepository;
import sg.edu.iss.test.repo.SupplierRepository;

@Service
public class CatalogueImplementation implements CatalogueInterface  {
	
	@Autowired
	ProductRepository prepo;
	
	@Autowired
	SupplierRepository srepo;
	
	@Transactional
	public void save(Product product) {
		prepo.save(product);
	}
	
	@Transactional(timeout = 30, readOnly = true)
	public List<Product> list() {
		return prepo.findAll();
	}
	
	

}
