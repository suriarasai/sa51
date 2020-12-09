package sg.edu.iss.test.service;

import java.util.List;

import sg.edu.iss.test.model.Product;

public interface CatalogueInterface {

	public void save(Product product);
	public List<Product> list();

}