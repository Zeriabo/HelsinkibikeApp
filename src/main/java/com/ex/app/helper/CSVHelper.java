package com.ex.app.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.ex.app.models.Journey;

public class CSVHelper {
	 public static String TYPE = "text/csv";
	 static DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
	  static String[] HEADERs = { "Departure", "Return", "Departure station id", "Departure station name","Return station id","Return station name","Covered distance (m)","Duration (sec.)" };


	  public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	  public static List<Journey> csvToTutorials(InputStream is) throws ParseException {
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

		      List<Journey> tutorials = new ArrayList<Journey>();

		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		      for (CSVRecord csvRecord : csvRecords) {
		    	  Journey journey = new Journey();
                 journey.setArrival(formatter.parse(csvRecord.get("Return")));
                 journey.setArrivalStationId( Integer.parseInt( csvRecord.get("Return station id")));
                 journey.setCoveredDistance( Integer.parseInt(csvRecord.get("Covered distance (m)")));
                 journey.setDeparture(formatter.parse(csvRecord.get("Departure")));
                 journey.setDepartureStationId(Integer.parseInt(csvRecord.get("Departure station id")));
                 journey.setDepartureStationName(csvRecord.get("Departure station name"));
                 journey.setDuration(Integer.parseInt( csvRecord.get("Duration (sec.)")));
                 journey.setArrivalStationName(csvRecord.get("Departure station name"));

		        tutorials.add(journey);
		      }

		      return tutorials;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }
}
