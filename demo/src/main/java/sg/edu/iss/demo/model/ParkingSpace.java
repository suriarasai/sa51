package sg.edu.iss.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int lot;
	private String location;
	@OneToOne(mappedBy = "parkingSpace")
	private Employee employee;
	public ParkingSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParkingSpace(int lot, String location, Employee employee) {
		super();
		this.lot = lot;
		this.location = location;
		this.employee = employee;
	}
	public ParkingSpace(int lot, String location) {
		super();
		this.lot = lot;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLot() {
		return lot;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "ParkingSpace [id=" + id + ", lot=" + lot + ", location=" + location + ", employee=" + employee + "]";
	}
	
	

}