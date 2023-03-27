package com.ex.app.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ex.app.models.Asemat;
import com.ex.app.models.Journey;

public interface AsemaPaginationRepository extends PagingAndSortingRepository<Asemat,Long> {


@Query(value = "SELECT * FROM public.asemat a WHERE a.kaupunki = ?1", nativeQuery = true)
	Page<Asemat> searchAsematBYCity(String city,PageRequest pageable);


@Query(value = "SELECT * FROM public.asemat a WHERE a.name = ?1", nativeQuery = true)
Page<Asemat> searchAsematByName(String search,PageRequest pageable);


@Query(value = "SELECT * FROM public.asemat a WHERE a.kapasiteet = ?1", nativeQuery = true)
Page<Asemat> searchAsematByCapacity(int search,PageRequest pageable);




}


