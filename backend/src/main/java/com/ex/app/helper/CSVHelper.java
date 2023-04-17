package com.ex.app.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.ex.app.models.Asemat;
import com.ex.app.models.Journey;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	static String[] HEADERs = { "Departure", "Return", "Departure station id", "Departure station name",
			"Return station id", "Return station name", "Covered distance (m)", "Duration (sec.)" };


	public static boolean hasCSVFormat(File file) {
	    String fileName = file.getName();
	    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
	    return extension.equalsIgnoreCase("csv");
	}
	public static List<Journey> csvToJourneys(InputStream is) throws ParseException {
	    List<Journey> journeys = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
	         CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().parse(reader)) {

	        for (CSVRecord record : parser) {
	            Journey journey = new Journey();
	            try {
	                LocalDateTime departure = LocalDateTime.parse(record.get(0), formatter);
	                LocalDateTime arrival = LocalDateTime.parse(record.get("Return"), formatter);
	                double duration = Double.parseDouble(record.get("Duration (sec.)"));
	                double distance = Double.parseDouble(record.get("Covered distance (m)"));
	                int departureStationId = Integer.parseInt(record.get("Departure station id"));
	                int arrivalStationId = Integer.parseInt(record.get("Return station id"));

	                // Only add the journey if all the conditions are met
	                if (departure != null && arrival != null
	                        && Duration.between(departure, arrival).getSeconds() >= 11
	                        && distance >= 10 && duration >= 10) {

	                    journey.setDeparture(departure);
	                    journey.setArrival(arrival);
	                    journey.setDepartureStationId(departureStationId);
	                    journey.setDepartureStationName(record.get("Departure station name"));
	                    journey.setArrivalStationId(arrivalStationId);
	                    journey.setArrivalStationName(record.get("Return station name"));
	                    journey.setDuration(duration);
	                    journey.setCoveredDistance(distance);
	                    journeys.add(journey);
	                }
	            } catch (Exception ex) {
	                System.err.println("Error while processing CSV record: " + ex.getMessage());
	            }
	        }

	    } catch (IOException e) {
	        throw new RuntimeException("Failed to parse CSV file: " + e.getMessage(), e);
	    }

	    return journeys;
	}


	public static List<Asemat> csvToAsemat(InputStream is) throws ParseException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Asemat> asemat = new ArrayList<Asemat>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Asemat asema = new Asemat();
				try {
                    asema.setFid(Long.parseLong(csvRecord.get(0)));
					asema.setId(Long.parseLong(csvRecord.get("ID")));
					asema.setKapasiteet(Integer.parseInt(csvRecord.get("Kapasiteet")));
					asema.setKaupunki(csvRecord.get("Kaupunki"));
					asema.setOsoite(csvRecord.get("Osoite"));
					asema.setStad(csvRecord.get("Stad"));
					asema.setAdres(csvRecord.get("Adress"));
					asema.setName(csvRecord.get("Name"));
					asema.setNamn(csvRecord.get("Namn"));
					asema.setNimi(csvRecord.get("Nimi"));
					asema.setOperator(csvRecord.get("Operaattor"));
					asema.setX(Double.parseDouble(csvRecord.get("x")));
					asema.setX(Double.parseDouble(csvRecord.get("y")));

				} catch (Exception ex) {
					throw ex;

				}

				asemat.add(asema);
			}

			return asemat;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}

	}
}
