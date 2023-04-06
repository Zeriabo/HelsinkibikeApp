package com.ex.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ex.app.models.Asemat;
import com.ex.app.repository.AsemaPaginationRepository;
import com.ex.app.repository.AsematRepository;

@Service
public class AsemaService {

	@Autowired
	AsemaPaginationRepository asematPaginationRepository;

	@Autowired
	AsematRepository asematRepository;

	public Page<Asemat> getAllAsemat() {

		PageRequest pr = PageRequest.of(1, 100, Sort.by("id"));
		
		Page<Asemat> result = asematPaginationRepository.findAll(pr);

		return result;
	}

	public Page<Asemat> getAllStations() {

		PageRequest pr = PageRequest.of(1, 100, Sort.by("id"));
		
		Page<Asemat> result = asematPaginationRepository.findAll(pr);

		return result;
	}
	
	public Page<Asemat> getAllStationsJourneysSearchedByCapacity(int capacity) {

		PageRequest pr = PageRequest.of(1, 100, Sort.by("id"));
		
		Page<Asemat> result = asematPaginationRepository.searchAsematByCapacity(capacity,pr);

		return result;
	}
	
	public Optional<Asemat> getStationById(long id) {

		Optional<Asemat> result = asematRepository.findById(id);

		return result;
	}
     
	public List<Object> getStation(long id) {

		List<Object> result = asematRepository.getStationInfo(id);

		return result;
	}
	
	public List<Object> getSngleStation(long id) {

		List<Object> result = asematRepository.getSingleStationInfo(id);

		return result;
	}

	public Object getStationLocation(int id) {
		Object result = asematRepository.getLocation(id);

		return result;
	
	}
	
	public Object getMostFiveReturn() {
		Object result = asematRepository.getMostFiveReturn();

		return result;
	
	}
	
	public Object getMostFiveDeparture() {
		List<Object> result = asematRepository.getMostFiveDeparture();
		return result;
	
	}
	
	public Asemat createAsema(Asemat asema) {
		try {
		 Asemat result = asematRepository.save(asema);
		 return result;
		}catch(Exception e)
		{
			throw e;
		}
		
	
	}

}