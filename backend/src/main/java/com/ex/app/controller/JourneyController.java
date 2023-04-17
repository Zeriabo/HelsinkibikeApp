package com.ex.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ex.app.models.Journey;
import com.ex.app.models.ResponseMessage;
import com.ex.app.services.CSVService;
import com.ex.app.services.JourneyService;

@CrossOrigin
@RequestMapping("/journey")
@RestController
public class JourneyController {

    @Autowired
    private CSVService fileService;

    @Autowired
    private JourneyService journeyService;

    @GetMapping("/")
    public ResponseEntity<Page<Journey>> getJourneys(
            @RequestParam(defaultValue = "0") Integer page) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(journeyService.getAllJourneysSortedBy("id", page));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/sorted")
    public ResponseEntity<Page<Journey>> getJourneysSorted(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "id") String sortedBy) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(journeyService.getAllJourneysSortedBy(sortedBy, page));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/search_departure")
    public ResponseEntity<Page<Journey>> getSearchByDepartureJourneys(
            @RequestParam int id, @RequestParam int page) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(journeyService.getAllJourneysSearchedByDeparture(id, page));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/search_arrival")
    public ResponseEntity<Page<Journey>> getAllJourneysSearchedByArrival(
            @RequestParam int id, @RequestParam int page) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(journeyService.getAllJourneysSearchedByArrival(id, page));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/avg_departure")
    public ResponseEntity<Object> getAVGDeparture(@RequestParam String idParam) {
        try {
            int id = Integer.parseInt(idParam);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(journeyService.getAVGDepartureDistance(id));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/avg_arrival")
    public ResponseEntity<Object> getAVGArrival(@RequestParam String idParam) {
        try {
            int id = Integer.parseInt(idParam);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(journeyService.getAVGArrivalDistance(id));
        } catch (Exception e) {
            throw e;
        }
}
}