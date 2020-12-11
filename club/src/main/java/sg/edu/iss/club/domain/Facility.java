package sg.edu.iss.club.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer facilityId;
	private String name;
    private String description;
	public Facility() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facility(Integer facilityId, String name, String description) {
		super();
		this.facilityId = facilityId;
		this.name = name;
		this.description = description;
	}
	public Facility(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Integer getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Facility [facilityId=" + facilityId + ", name=" + name + ", description=" + description + "]";
	}
    
    
	
}
