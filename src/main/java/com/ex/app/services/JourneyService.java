package com.ex.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ex.app.models.Journey;
import com.ex.app.repository.AsematRepository;
import com.ex.app.repository.JourneyPaginationRepository;
import com.ex.app.repository.JourneyRepository;

@Service
public class JourneyService {
	@Autowired
	JourneyRepository journeyRepository;
	@Autowired
	AsematRepository asematRepository;
	@Autowired
	JourneyPaginationRepository journeyPaginationRepsitory;

	public List<Journey> getAllJourneys() {


		List<Journey> pagedResult = journeyRepository.findAll();

		return pagedResult;
	}

	public Page<Journey> getAllJourneysSortedBy(String sort) {

		PageRequest pr = PageRequest.of(1, 100, Sort.by(sort));

		Page<Journey> pagedResult = journeyRepository.findAll(pr);

		return pagedResult;
	}

}