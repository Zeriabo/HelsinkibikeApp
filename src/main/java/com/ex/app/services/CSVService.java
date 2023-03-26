package com.ex.app.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ex.app.helper.CSVHelper;
import com.ex.app.models.Asemat;
import com.ex.app.models.Journey;
import com.ex.app.repository.AsematRepository;
import com.ex.app.repository.JourneyRepository;

@Service
public class CSVService {

	 @Autowired
	 JourneyRepository journeyRepository;
	 @Autowired
	 AsematRepository asematRepository;

	  public void saveJourneys(File file) throws ParseException {
		    try {
		    	//Don't import journeys that lasted for less than ten seconds
		    	//Don't import journeys that covered distances shorter than 10 meters
		    	FileInputStream fis= new FileInputStream(file);
		    	try {
		    		 List<Journey> journeys = CSVHelper.csvToJourneys(fis); 
		    		 journeyRepository.saveAll(journeys);
		    	}catch (Exception e) {
		    		throw new RuntimeException("fail to store csv data: " + e.getMessage() + e.getCause());
			    }
		     
		      
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }

	  public void saveAsemat(File file) throws ParseException {
		    try {
		    	
		    	FileInputStream fis= new FileInputStream(file);
		    	try {
		    		 List<Asemat> asemat = CSVHelper.csvToAsemat(fis);
		    		 asematRepository.saveAll(asemat);
		    	}catch (Exception e) {
		    		throw new RuntimeException("fail to store csv data: " + e.getMessage() + e.getCause());
			    }
		     
		      
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }
		  public List<Journey> getAllJourneys() {
		    return journeyRepository.findAll();
		  }
}
