package sg.edu.iss.club.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.repo.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired
	FacilityRepository frepo;

	@Transactional
	public boolean saveFacility(Facility facility) {
		if(frepo.save(facility)!=null) return true; else return false;
	}

	@Transactional
	public ArrayList<Facility> findAllFacilities() {
		return (ArrayList<Facility>) frepo.findAll();
	}

	@Transactional
	public Facility findFacilityById(Integer id) {
		return frepo.findById(id).get();
	}

	@Transactional
	public void deleteFacility(Facility facility) {
		 frepo.delete(facility);
	}

	@Transactional
	public ArrayList<String> findAllFacilityNames() {
		List<Facility> facilitys = frepo.findAll();
		ArrayList<String> names = new ArrayList<String>();
		for (Iterator<Facility> iterator = facilitys.iterator(); iterator.hasNext();) {
			Facility facility = (Facility) iterator.next();
			names.add(facility.getName());
		}
		return names;
	}
	
	@Transactional
	public Facility findFacilityByName(String name) {
		return frepo.findFacilitiesByName(name).get(0);
	}

}
