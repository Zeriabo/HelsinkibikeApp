package com.ex.app.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

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
import com.ex.app.models.Asemat;
import com.ex.app.models.ResponseMessage;
import com.ex.app.services.AsemaService;
import com.ex.app.services.CSVService;

@CrossOrigin("http://localhost:8080")
@RequestMapping("/asema")
@RestController
public class AsemaController {

	@Autowired
	CSVService fileService;
	
	@Autowired
	AsemaService asemaService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile() {
		String message = "";

		try {
			File file = new File("src/main/resources/Helsingin_ja_Espoon_kaupunkipy_asemat_avoin.csv");
	

			fileService.saveAsemat(file);

		

			message = "Uploaded the file successfully: " + file.getName();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file  !";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}
	
	@GetMapping("/")
	public ResponseEntity<Page<Asemat>> getJourneys() {


		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getAllStations());
		} catch (Exception e) {
		
			throw e;
		}

	}
	@GetMapping("/search_capacity")
	public ResponseEntity<Page<Asemat>> getStationsByCapacity(@RequestParam String search) {


		try {
			int capacity = Integer.parseInt(search);
				
			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getAllStationsJourneysSearchedByCapacity(capacity));
		} catch (Exception e) {
		
			throw e;
		}

	}
	@GetMapping("/single")
	public ResponseEntity<List<Object>> getSingleStation(@RequestParam String search) {


		try {
			int id = Integer.parseInt(search);

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getStation(id));
		} catch (Exception e) {
		
			throw e;
		}

	}
	
	@GetMapping("/location")
	public ResponseEntity<Object> getStationLocation(@RequestParam String idParam) {


		try {
			int id = Integer.parseInt(idParam);

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getStationLocation(id));
		} catch (Exception e) {
		
			throw e;
		}

	}
	

}
