package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.cg.entities.Workshop;
@Repository("workshopDao")
public class WorkshopDaoImpl  implements IWorkshopDao
{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	
	public List<Workshop> getAllScheduledWS()
	{
		TypedQuery<Workshop> query = entityManager.createQuery("SELECT w FROM Workshop w", Workshop.class);
		List<Workshop> wsL=query.getResultList();
		return wsL;
		
	}

}
