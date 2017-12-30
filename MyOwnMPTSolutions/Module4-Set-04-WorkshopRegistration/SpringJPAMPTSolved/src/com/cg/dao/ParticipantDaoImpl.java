package com.cg.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entities.Participants;
@Repository("participantDao")
public class ParticipantDaoImpl implements IParticipantDAO 
{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Participants addParticipants(Participants part) 
	{		
		part.setRegistrationDate(new Date());
		 entityManager.persist(part);
		 entityManager.flush();
		
		 return part;
	}
	@Override
	public long getNoOfParticipantCount(long workshopId) 
	{
		/*String qry="SELECT COUNT(part) FROM Participants part  GROUP BY  "+
				" part.workshop.workshopId  HAVING  "+
				" part.workshop.workshopId  IN (:wid )  ";*/
		
		String qry="SELECT COUNT(part) FROM Participants part  GROUP BY  "+
				" part.wid  HAVING  "+
				" part.wid  IN (:woid )  ";
		Long woId=(long)workshopId; 
		TypedQuery<Long> tq=entityManager.createQuery(qry,Long.class);
		tq.setParameter("woid", woId);
		Long count=0L;
		try
		{
			count=tq.getSingleResult();
			System.out.println(" Count Is : "+count.longValue());
		}
		catch(Exception e)
		{
			return 0L;		
		}		
		return count;		
	}

}
