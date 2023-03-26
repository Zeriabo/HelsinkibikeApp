package com.ex.app.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ex.app.helper.CSVHelper;
import com.ex.app.models.ResponseMessage;
import com.ex.app.repository.JourneyRepository;
import com.ex.app.services.CSVService;

@CrossOrigin("http://localhost:8080")
@RequestMapping("/asema")
@RestController
public class AsemaController {

	@Autowired
	CSVService fileService;

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

}
