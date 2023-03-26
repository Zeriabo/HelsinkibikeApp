package com.ex.app.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ex.app.models.Journey;

public interface JourneyPaginationRepository extends PagingAndSortingRepository<Journey,Long> {

//	List<Journey> findAllJouneys(Pageable pageable);
}
