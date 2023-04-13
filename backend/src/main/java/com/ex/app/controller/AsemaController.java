package com.ex.app.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ex.app.exceptions.InputException;
import com.ex.app.models.Asemat;
import com.ex.app.models.Journey;
import com.ex.app.models.ResponseMessage;
import com.ex.app.services.AsemaService;
import com.ex.app.services.CSVService;

@CrossOrigin
@RequestMapping("/asema")
@RestController
public class AsemaController {

	@Autowired
	CSVService fileService;
	
	@Autowired
	AsemaService asemaService;

public AsemaController()
{
	
}
	@PostMapping("/")
	public ResponseEntity<Asemat> createAsema(@RequestBody Object  asema) throws Exception {
		

		ModelMapper modelMapper = new ModelMapper();
		Asemat newAsema = modelMapper.map(asema, Asemat.class);
    if(newAsema.getAdres()==null  || newAsema.getKaupunki()==null || newAsema.getName()==null ||newAsema.getNamn()==null || newAsema.getNimi() ==null 
    		|| newAsema.getOperator()==null || newAsema.getOsoite()== null ||newAsema.getStad()==null )
    {
    	throw new InputException("Wrong input!");
    }
		try {
			
				return ResponseEntity.status(HttpStatus.OK).body(asemaService.createAsema(newAsema));
		} catch (Exception e) {
		
			throw e;
		}

	}
	
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
	public ResponseEntity<Page<Asemat>> getStations(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "id")  String sortedBy) {


		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getAllStations(sortedBy, page));
		} catch (Exception e) {
		
			throw e;
		}

	}
	@GetMapping("/sorted")
	public ResponseEntity<Page<Asemat>> getJourneysSorted(@RequestParam(defaultValue = "1") Integer page,@RequestParam String sortedBy) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getAllStations(sortedBy, page));
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
	public ResponseEntity<List<Object>> getSingleStation(@RequestParam String idParam) {


		try {
			int id = Integer.parseInt(idParam);

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getSngleStation(id));
		} catch (Exception e) {
		
			throw e;
		}

	}
	
	@GetMapping("/location")
	public ResponseEntity<Object> getStationLocation(@RequestParam Long idParam) {


		try {
		

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getStationLocation(idParam));
		} catch (Exception e) {
		
			throw e;
		}

	}
	@GetMapping("/fivereturn")
	public ResponseEntity<Object> getMostFiveReturn(@RequestParam Long idParam) {


		try {

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getMostFiveReturn(idParam));
		} catch (Exception e) {
		
			throw e;
		}

	}
	
	@GetMapping("/fivedeparture")
	public ResponseEntity<Object> getMostFiveDeparture(@RequestParam Long idParam) {


		try {

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getMostFiveDeparture(idParam));
		} catch (Exception e) {
		
			throw e;
		}

	}
	
	@GetMapping("/totaldeparture")
	public ResponseEntity<Object> getTotalDeparture(@RequestParam long id) {


		try {

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getTotalDeparture(id));
		} catch (Exception e) {
		
			throw e;
		}

	}
	@GetMapping("/totalarrival")
	public ResponseEntity<Object> getTotalArrival(@RequestParam long id) {


		try {

			return ResponseEntity.status(HttpStatus.OK).body(asemaService.getTotalArrival(id));
		} catch (Exception e) {
		
			throw e;
		}

	}
	

}
