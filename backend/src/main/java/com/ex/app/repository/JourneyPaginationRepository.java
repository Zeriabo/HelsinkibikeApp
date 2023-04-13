package com.ex.app.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ex.app.models.Journey;

public interface JourneyPaginationRepository extends PagingAndSortingRepository<Journey,Long> {


@Query(value = "SELECT * FROM public.journey j WHERE j.departure_station_id= ?1", nativeQuery = true)
	Page<Journey> searchJourneysByDeparture(int id,PageRequest pageable);


@Query(value = "SELECT * FROM public.journey j WHERE j.arrival_station_id = ?1", nativeQuery = true)
Page<Journey> searchJourneysByArrival(int id,PageRequest pageable);



}


