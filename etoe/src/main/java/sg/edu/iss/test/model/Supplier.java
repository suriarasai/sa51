package sg.edu.iss.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String supplierName;
	private String supplierAddress;
	private String phone;
	private String email;
	@OneToOne(mappedBy = "supplier")
	private Product  product;
	public Supplier(String supplierName, String supplierAddress, String phone, String email) {
		super();
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.phone = phone;
		this.email = email;
	}
	

}
