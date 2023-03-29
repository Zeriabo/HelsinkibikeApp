package com.ex.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ex.app.models.Journey;

public interface JourneyRepository extends JpaRepository<Journey,Long> {


	@Query(value="SELECT AVG(covered_distance) as AVG_DEPARTURE "
			+ "FROM public.journey "
			+ "where departure_station_id=?1", nativeQuery = true)
	Object getAverageDepartureDistance(String id);
	
	@Query(value="SELECT AVG(covered_distance) as AVG_ARRIVAL "
			+ "FROM public.journey "
			+ "where arrival_station_id=?1", nativeQuery = true)
	Object getAverageArrivalDistance(String id);
}
