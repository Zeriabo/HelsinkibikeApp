package com.ex.app.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ex.app.models.Journey;
import com.ex.app.repository.JourneyPaginationRepository;
import com.ex.app.repository.JourneyRepository;

@Service
public class JourneyService {
	@Autowired
	JourneyRepository journeyRepository;
	
	@Autowired
	JourneyPaginationRepository journeyPaginationRepsitory;

	public List<Journey> getAllJourneys() {


		List<Journey> pagedResult = journeyRepository.findAll();

		return pagedResult;
	}

	public Page<Journey> getAllJourneysSortedBy(String sort,Integer page) {

		PageRequest pr = PageRequest.of(page, 100, Sort.by(sort));

		Page<Journey> pagedResult = journeyRepository.findAll(pr);

		return pagedResult;
	}

	public Page<Journey> getAllJourneysSearchedByDeparture( int id, int page) {
		
		PageRequest pr = PageRequest.of(page, 10,Sort.unsorted());
		Page<Journey> pagedResult = journeyPaginationRepsitory.searchJourneysByDeparture(id, pr);

		return pagedResult;
	}
	
public Page<Journey> getAllJourneysSearchedByArrival( int id,int page) {
		
		PageRequest pr = PageRequest.of(page, 10,Sort.unsorted());
		Page<Journey> pagedResult = journeyPaginationRepsitory.searchJourneysByArrival(id, pr);

		return pagedResult;
	}

public Object getAVGDepartureDistance( int id) {
	
	Object pagedResult = journeyRepository.getAverageDepartureDistance(id);

	return pagedResult;
}

public Object getAVGArrivalDistance( int id) {
	

	Object pagedResult = journeyRepository.getAverageArrivalDistance(id);

	return pagedResult;
}

public Journey createJourney( Journey journey) {
	
	Journey newJourney = journeyRepository.save(journey);

	return newJourney;
}
}