package com.ex.app.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ex.app.models.Journey;
import com.ex.app.models.ResponseMessage;
import com.ex.app.services.CSVService;
import com.ex.app.services.JourneyService;

@CrossOrigin	
@RequestMapping("/journey")
@RestController
public class JourneyController {

	@Autowired
	CSVService fileService;
	@Autowired
	JourneyService journeyService;
	
	ClassPathResource resource5 = new ClassPathResource("2021-05.csv");
	ClassPathResource resource6 = new ClassPathResource("2021-06.csv");
	ClassPathResource resource7 = new ClassPathResource("2021-07.csv");

	@GetMapping("/")
	public ResponseEntity<Page<Journey>> getJourneys(@RequestParam(defaultValue = "0") Integer page) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSortedBy("id", page));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/sorted")
	public ResponseEntity<Page<Journey>> getJourneysSorted(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "id") String sortedBy) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSortedBy(sortedBy,page));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/search_departure")
	public ResponseEntity<Page<Journey>> getSearchByDepartureJourneys(@RequestParam int id,@RequestParam int page) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSearchedByDeparture(id,page));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/search_arrival")
	public ResponseEntity<Page<Journey>> getAllJourneysSearchedByArrival(@RequestParam int id,@RequestParam int page) {


		try {
		

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAllJourneysSearchedByArrival(id,page));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/avg_departure")
	public ResponseEntity<Object> getAVGDeparture(@RequestParam String idParam) {
		
		try {
			 int id = Integer.parseInt(idParam);
			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAVGDepartureDistance(id));
		} catch (Exception e) {

			throw e;
		}

	}

	@GetMapping("/avg_arrival")
	public ResponseEntity<Object> getAVGArrival(@RequestParam String idParam) {

		try {
			 int id = Integer.parseInt(idParam);
			return ResponseEntity.status(HttpStatus.OK).body(journeyService.getAVGArrivalDistance(id));
		} catch (Exception e) {

			throw e;
		}

	}
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile() {
		String message = "";

		try {
			
			File file = resource5.getFile();
//			File file = new File("src/main/resources/2021-05.csv");
//			File file2 = new File("src/main/resources/2021-06.csv");
//			File file3 = new File("src/main/resources/2021-07.csv");
			File file2 =resource6.getFile();
			File file3 = resource7.getFile();
       
			fileService.saveJourneys(file);
			fileService.saveJourneys(file2);
			fileService.saveJourneys(file3);

			message = "Uploaded the files successfully";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file! "+e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}
	
	@PostMapping("/")
	public ResponseEntity<Journey> createJourney( @RequestBody Journey newJourney  ) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(journeyService.createJourney(newJourney));
		} catch (Exception e) {

			throw e;
		}

	}
	

}
