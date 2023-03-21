package com.ex.app.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Journey {

	public Journey()
	{
		
	}
	public Journey(Long id,Date departure,Date arrival, int departureStationId,int arrivalStationId,
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
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
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
	public int getCoveredDistance() {
		return coveredDistance;
	}
	public void setCoveredDistance(int coveredDistance) {
		this.coveredDistance = coveredDistance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	private @Id @GeneratedValue  Long  id;
	private Date departure;
	private Date arrival;
	private int departureStationId;
	private int arrivalStationId;
    private String arrivalStationName;
    private String departureStationName;
    private int coveredDistance;
    private int duration;
	
}
