package sg.edu.iss.club.service;

import java.util.ArrayList;

import sg.edu.iss.club.domain.Facility;

public interface FacilityService {
	 public boolean saveFacility(Facility facility);
	 public ArrayList<Facility> findAllFacilities();
	 public Facility findFacilityById(Integer id);
	 public void deleteFacility(Facility facility);
	 public ArrayList<String> findAllFacilityNames();
	 public Facility findFacilityByName(String name);
}
