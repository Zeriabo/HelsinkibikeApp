package com.ex.app.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ex.app.helper.CSVHelper;
import com.ex.app.models.Journey;
import com.ex.app.repository.JourneyRepository;

@Service
public class CSVService {
	
	 @Autowired
	 JourneyRepository journeyRepository;

	  public void save(MultipartFile file) throws ParseException {
		    try {
		      List<Journey> journeys = CSVHelper.csvToJourneys(file.getInputStream());
		      journeyRepository.saveAll(journeys);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }

		  public List<Journey> getAllTutorials() {
		    return journeyRepository.findAll();
		  }
}
