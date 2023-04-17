package com.ex.app.services;

import com.ex.app.helper.CSVHelper;
import com.ex.app.models.Asemat;
import com.ex.app.models.Journey;
import com.ex.app.repository.AsematRepository;
import com.ex.app.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Service
public class CSVService {

    private final JourneyRepository journeyRepository;
    private final AsematRepository asematRepository;

    @Autowired
    public CSVService(JourneyRepository journeyRepository, AsematRepository asematRepository) {
        this.journeyRepository = journeyRepository;
        this.asematRepository = asematRepository;
    }

    public void saveJourneys(File file) throws ParseException {
        try (FileInputStream fis = new FileInputStream(file)) {
            List<Journey> journeys = CSVHelper.csvToJourneys(fis);

            // Filter out journeys that lasted for less than 10 seconds or covered distances shorter than 10 meters
            journeys.removeIf(journey -> journey.getDuration() < 10 || journey.getCoveredDistance() < 10);

            journeyRepository.saveAll(journeys);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store CSV data: " + e.getMessage(), e);
        }
    }

    public void saveAsemat(File file) throws ParseException {
        try (FileInputStream fis = new FileInputStream(file)) {
            List<Asemat> asemat = CSVHelper.csvToAsemat(fis);
            asematRepository.saveAll(asemat);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store CSV data: " + e.getMessage(), e);
        }
    }

    public List<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }
}
