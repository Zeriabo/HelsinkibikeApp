package com.ex.app.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public static boolean hasCSVFormat(File file) {

//	    if (!TYPE.equals(file.())) {
//	      return false;
//	    }

		return true;
	}

	public static List<Journey> csvToJourneys(InputStream is) throws ParseException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Journey> journeys = new ArrayList<Journey>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Journey journey = new Journey();
				try {

					if ((csvRecord.get(0).length() == 19) && (csvRecord.get(1).length() == 19)) {

						if (!(LocalDateTime.parse(csvRecord.get(0)).until(LocalDateTime.parse(csvRecord.get("Return")),
								ChronoUnit.SECONDS) < 11)

								&& !(csvRecord.get(6).length() == 0)

								&& !(Double.parseDouble(csvRecord.get(6)) < 10 || csvRecord.get(6) == null)

								&& !(Double.parseDouble(csvRecord.get("Duration (sec.)")) < 10
										|| csvRecord.get("Duration (sec.)").length() == 0
										|| csvRecord.get("Duration (sec.)") == null))

						{

							if (csvRecord.get("Return").trim().length() == 0) {
								journey.setArrival(null);

							} else if (csvRecord.get("Return") == "") {
								journey.setArrival(null);
							} else if (csvRecord.get("Return").trim().length() == 1) {
								journey.setArrival(null);
							} else if (csvRecord.get("Return").trim().length() > 15) {
								journey.setArrival(LocalDateTime.parse(csvRecord.get("Return"), formatter));
							}

							if (csvRecord.get(0).length() == 0) {
								journey.setDeparture(null);
							} else if (csvRecord.get(0).trim().length() > 15) {
								journey.setDeparture(LocalDateTime.parse(csvRecord.get(0), formatter));
							} else {
								journey.setDeparture(null);
							}

							journey.setDepartureStationName(csvRecord.get("Departure station name"));
							journey.setArrivalStationName(csvRecord.get("Return station name"));

							try {
								if (csvRecord.get("Duration (sec.)") == "") {
									journey.setDuration(0);
								} else {
									journey.setDuration(Double.parseDouble(csvRecord.get("Duration (sec.)"))); //
								}
								if (csvRecord.get("Return station id") == "") {
									journey.setArrivalStationId(0);
								} else {
									journey.setArrivalStationId(Integer.parseInt(csvRecord.get("Return station id"))); //
								}
								if (csvRecord.get("Covered distance (m)") == "") {
									journey.setCoveredDistance(0);
								} else {

									journey.setCoveredDistance(Double.parseDouble(csvRecord.get(6)));

								}
								if (csvRecord.get("Departure station id") == "") {
									journey.setDepartureStationId(0);
								} else {
									journey.setDepartureStationId(
											Integer.parseInt(csvRecord.get("Departure station id"))); //
								}

							} catch (NumberFormatException nfe) {
								System.out.println(nfe.getMessage() + journey.getId() + journey.getArrival());
							}
							journeys.add(journey);

						}
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			return journeys;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}

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
					System.out.println(ex.getMessage() + "    " + ex);

				}

				asemat.add(asema);
			}

			return asemat;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}

	}
}
