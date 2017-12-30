package com.cg.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;

import com.cg.training.dto.Training;
@Repository
public class TrainingDaoImpl implements TrainingDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Training> getAll() {
		// TODO Auto-generated method stub
		//System.out.println("hiii");
		Query query = entityManager.createQuery("FROM Training");
		//System.out.println("table data ....");
		
		
		
		return query.getResultList();
	}

	@Override
	public Training getDetail(String id) {
		// TODO Auto-generated method stub
		
		Query queryOne=entityManager.createQuery("FROM Training where tid=:id");
		queryOne.setParameter("id",id);
		List<Training> tra=queryOne.getResultList();
		return tra.get(0);
	}
 
	@Override
	public int updateData(Training tra) {
		// TODO Auto-generated method stub
		/*String queryth="UPDATE ScheduledSessions SET name =?,duration=?,faculty=?,mode1=? where id=?";
		*/
		//System.out.println(tra);
		//entityManager=entityManager.getEntityManagerFactory().createEntityManager();
		Training traData=entityManager.find(Training.class,tra.gettId());
		//System.out.println("Faculty to data"+traData.gettFaculty()+" Faclty update "+tra.gettFaculty());
		traData.settName(tra.gettName());
		traData.settDuration(tra.gettDuration());
		traData.settFaculty(tra.gettFaculty());
		traData.settMode(tra.gettMode());
		
		entityManager.merge(traData);
		return 1;
	}

}
