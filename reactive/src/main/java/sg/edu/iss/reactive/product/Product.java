package sg.edu.iss.reactive.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	private String id;
	@Indexed(unique=true)
	private int productId;
	private String name;
	@Version
	private Integer version;
	private int weight;
	public Product(int productId, String name, Integer version, int weight) {
		super();
		this.productId = productId;
		this.name = name;
		this.version = version;
		this.weight = weight;
	}
	
	public Product(int productId, String name, int weight) {
		super();
		this.productId = productId;
		this.name = name;
		this.weight = weight;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", version=" + version
				+ ", weight=" + weight + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

}
