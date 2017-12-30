package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Workshop;

@Repository("workshopDao")
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

	
	
}