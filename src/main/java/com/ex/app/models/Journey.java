package com.ex.app.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Journey {

	public Journey()
	{
		
	}
	public Journey(Long id,LocalDateTime departure,LocalDateTime arrival, int departureStationId,int arrivalStationId,
			String arrivalStationName,	String departureStationName,int coveredDistance,int duration)
	{
		this.id=id;
		this.arrival=arrival;
		this.arrivalStationId=arrivalStationId;
		this.arrivalStationName=arrivalStationName;
		this.coveredDistance=coveredDistance;
		this.departure=departure;
		this.departureStationId=departureStationId;
		this.departureStationName=departureStationName;
		this.duration=duration;
		
	     
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	public LocalDateTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}
	public int getDepartureStationId() {
		return departureStationId;
	}
	public void setDepartureStationId(int departureStationId) {
		this.departureStationId = departureStationId;
	}
	public int getArrivalStationId() {
		return arrivalStationId;
	}
	public void setArrivalStationId(int arrivalStationId) {
		this.arrivalStationId = arrivalStationId;
	}
	public String getArrivalStationName() {
		return arrivalStationName;
	}
	public void setArrivalStationName(String arrivalStationName) {
		this.arrivalStationName = arrivalStationName;
	}
	public String getDepartureStationName() {
		return departureStationName;
	}
	public void setDepartureStationName(String departureStationName) {
		this.departureStationName = departureStationName;
	}
	public double getCoveredDistance() {
		return coveredDistance;
	}
	public void setCoveredDistance(double coveredDistance) {
		this.coveredDistance = coveredDistance;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	private @Id @GeneratedValue  Long  id;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private int departureStationId;
	private int arrivalStationId;
    private String arrivalStationName;
    private String departureStationName;
    private double coveredDistance;
    private double duration;
	
}
