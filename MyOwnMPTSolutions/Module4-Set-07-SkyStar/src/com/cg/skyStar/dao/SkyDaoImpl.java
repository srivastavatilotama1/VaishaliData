package com.cg.skyStar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.cg.skyStar.bean.SkyStar;

@Repository
@Transactional
public class SkyDaoImpl implements ISkyDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<SkyStar> getAll() {
		TypedQuery<SkyStar> qry= em.createQuery("select p from SkyStar p",SkyStar.class);
		return qry.getResultList();
	}

	@Override
	public SkyStar getDetail(String custNum) {
		 return em.find(SkyStar.class,custNum);

	}

}
