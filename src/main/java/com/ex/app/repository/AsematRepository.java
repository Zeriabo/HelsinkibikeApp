package com.ex.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ex.app.models.Asemat;

public interface AsematRepository extends JpaRepository<Asemat,Long> {
	
	@Query(value = "SELECT q1.id,q1.name,q1.adres,q1.nbrJourneysEnding,q2.nbrJourneysStating FROM (SELECT asemat.id,name, adres, count(arrival_station_id) as nbrJourneysEnding "
			+ "FROM public.asemat as asemat,public.journey as journeys "
			+ "WHERE asemat.id=journeys.arrival_station_id "
			+ "AND asemat.id=?1 "
			+ "Group by asemat.id)q1 "
			+ "LEFT JOIN "
			+ "(SELECT asemat.id,name, adres, count(departure_station_id) as nbrJourneysStating "
			+ "FROM public.asemat as asemat,public.journey as journeys "
			+ "WHERE asemat.id=journeys.departure_station_id "
			+ " AND asemat.id=?1  "
			+ "Group by asemat.id)q2 "
			+ "on q1.id=q2.id "
			+ "ORDER BY "
			+ "   q1.id ASC;", nativeQuery = true)
	List<Object> getStationInfo(Long id);

	@Query(value="SELECT x,y FROM public.asemat "
			+ "WHERE id=?1", nativeQuery=true)
	Object getLocation(int id);

}   
