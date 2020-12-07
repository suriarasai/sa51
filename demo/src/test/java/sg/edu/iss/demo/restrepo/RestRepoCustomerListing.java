package sg.edu.iss.demo.restrepo;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestRepoCustomerListing {
	
	@Autowired
	CustomerRepository customerRepository;	
	
	@Test
	void listCustomers() {
		 ArrayList<Customer> clist = new ArrayList<Customer>();
	     clist = (ArrayList<Customer>) customerRepository.findAll();
	     for (Iterator<Customer> iterator = clist.iterator(); iterator.hasNext();) {
	    	 Customer customer =  iterator.next();
			System.out.println(customer.toString());
		}	
	}

}
