package com.ex.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ex.app.models.Journey;

import com.ex.app.services.JourneyService;

@CrossOrigin("http://localhost:8080")
@RequestMapping("/journey")
@RestController
public class JourneyController {

	@Autowired
	JourneyService journeyService;

	@GetMapping("/")
	public ResponseEntity<Page<Journey>> getJourneys() {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSortedBy("id"));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/sorted")
	public ResponseEntity<Page<Journey>> getJourneysSorted(@RequestParam String sortedBy) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSortedBy(sortedBy));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/search_departure")
	public ResponseEntity<Page<Journey>> getSearchByDepartureJourneys(@RequestParam String search) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSearchedByDeparture(search));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/search_arrival")
	public ResponseEntity<Page<Journey>> getAllJourneysSearchedByArrival(@RequestParam String idParam) {

		int id = Integer.parseInt(idParam);
		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSearchedByArrival(id));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/avg_departure")
	public ResponseEntity<Page<Journey>> getAVGDeparture(@RequestParam String idParam) {
		int id = Integer.parseInt(idParam);

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSearchedByArrival(id));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/avg_arrival")
	public ResponseEntity<Page<Journey>> getAVGArrival(@RequestParam String idParam) {
		int id = Integer.parseInt(idParam);

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSearchedByArrival(id));
		} catch (Exception e) {

			throw e;
		}

	}

}
