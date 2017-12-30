package com.cg.elms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.elms.entities.EmployeeDetails;
import com.cg.elms.entities.EmployeeLeaveDetails;

@Repository
@Transactional
public class LmsDaoOImpl implements ILmsDao {

	@PersistenceContext
	private EntityManager entityManger;

	@Override
	public EmployeeDetails getEmployeeDetails(int empId) {
		EmployeeDetails emp= entityManger.find(EmployeeDetails.class, empId);
		return emp;
	}

	@Override
	public List<EmployeeLeaveDetails> getLeaveDetails(int empId) {
		TypedQuery<EmployeeLeaveDetails> query = entityManger.createQuery(
				"SELECT l FROM EmployeeLeaveDetails l WHERE l.empId=:empId", EmployeeLeaveDetails.class);
		query.setParameter("empId", empId);
		return query.getResultList();
	}

}
