package sg.edu.iss.demo.restrepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestRepoCreateCustomersTests {
	
	@Autowired
	CustomerRepository customerRepository;	
	
	@Test
	void customerCreate() {
		customerRepository.save(new Customer("Angelia", "Lestari"));
	    customerRepository.save(new Customer("Cai Yaolong", "Derek"));
	    customerRepository.save(new Customer("Chan Jian", "Liu"));
	    customerRepository.save(new Customer("Chan Li Zhuo", "Wilson"));
	    customerRepository.save(new Customer("Chen Yihan", "Johanass"));
	}

}
