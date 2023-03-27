package com.ex.app.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ex.app.models.Asemat;
import com.ex.app.repository.AsemaPaginationRepository;

@Service
public class AsemaService {

	@Autowired
	AsemaPaginationRepository asematRepository;


	public Page<Asemat> getAllAsemat() {

		PageRequest pr = PageRequest.of(1, 100, Sort.by("id"));
		
		Page<Asemat> result = asematRepository.findAll(pr);

		return result;
	}

	public Page<Asemat> getAllJourneys() {

		PageRequest pr = PageRequest.of(1, 100, Sort.by("id"));
		
		Page<Asemat> result = asematRepository.findAll(pr);

		return result;
	}
	
	public Page<Asemat> getAllJourneysSearchedByCapacity(int capacity) {

		PageRequest pr = PageRequest.of(1, 100, Sort.by("id"));
		
		Page<Asemat> result = asematRepository.searchAsematByCapacity(capacity,pr);

		return result;
	}

}