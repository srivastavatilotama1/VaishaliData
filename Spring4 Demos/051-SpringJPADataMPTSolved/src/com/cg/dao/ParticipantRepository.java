package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Participants;

@Repository("participantDao")
public interface ParticipantRepository extends JpaRepository<Participants, Long> {

	@Query("SELECT COUNT(part) FROM Participants part  GROUP BY   part.wid  HAVING   part.wid  IN (:woid )")
	public long getNoOfParticipantCount(@Param("woid") long workshopId) ;
}