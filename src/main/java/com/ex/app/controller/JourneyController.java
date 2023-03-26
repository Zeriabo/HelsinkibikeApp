package com.ex.app.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ex.app.helper.CSVHelper;
import com.ex.app.models.Journey;
import com.ex.app.models.ResponseMessage;
import com.ex.app.repository.JourneyRepository;
import com.ex.app.services.CSVService;
import com.ex.app.services.JourneyService;

@CrossOrigin("http://localhost:8080")
@RequestMapping("/journey")
@RestController
public class JourneyController {


	@Autowired
    JourneyService journeyService;

	@GetMapping("/")
	public ResponseEntity<List<Journey>> getJourneys() {


		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneys());
		} catch (Exception e) {
		
			throw e;
		}

	}
	
	@GetMapping("/sorted")
	public ResponseEntity<Page<Journey>> getJourneysSorted(@RequestParam String sortedBy ) {


		try {
				
			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSortedBy(sortedBy));
		} catch (Exception e) {
		
			throw e;
		}

	}

}
