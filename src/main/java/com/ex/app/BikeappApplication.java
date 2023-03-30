package com.ex.app;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ex.app.controller.AsemaController;
import com.ex.app.controller.JourneyController;
import com.ex.app.models.Asemat;
import com.ex.app.models.Journey;
import com.ex.app.models.ResponseMessage;
import com.ex.app.services.CSVService;

@SpringBootApplication
public class BikeappApplication {
	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(BikeappApplication.class, args);

		 AsemaController asemaBean = context.getBean(AsemaController.class);
		                 JourneyController journeyBean = context.getBean(JourneyController.class);
		ResponseEntity<Page<Asemat>> asemat =asemaBean.getStations();
		if(asemat.getBody().getTotalElements()==0)
		{
			asemaBean.uploadFile();
		}
		ResponseEntity<Page<Journey>> journeys = journeyBean.getJourneys();
		if(journeys.getBody().getTotalElements()==0)
		{
			journeyBean.uploadFile();
		}
		
	}

}
