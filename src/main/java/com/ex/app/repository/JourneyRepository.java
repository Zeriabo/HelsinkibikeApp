package com.ex.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.app.models.Journey;

public interface JourneyRepository extends JpaRepository<Journey,Long> {

}
