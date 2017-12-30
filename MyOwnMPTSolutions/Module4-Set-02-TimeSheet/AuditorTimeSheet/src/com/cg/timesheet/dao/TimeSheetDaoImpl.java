package com.cg.timesheet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.timesheet.bean.TimeSheetBean;
import com.cg.timesheet.exception.TimeSheetException;

@Transactional
@Repository
public class TimeSheetDaoImpl implements ITimeSheetDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public int addTiemSheet(TimeSheetBean timeSheet) throws TimeSheetException {
		int timeSheetId=-1;
		try{
			entityManager.persist(timeSheet);
			entityManager.flush();
			timeSheetId=timeSheet.getId();
		}catch(RuntimeException exp){
			throw new TimeSheetException(exp.getMessage());
		}
		return timeSheetId;
	}

	@Override
	public List<TimeSheetBean> getRelatedTimeSheets(String empId)
			throws TimeSheetException {
		List<TimeSheetBean> timeSheets=null;
		try{
			String qryString = "SELECT ts FROM TimeSheetBean ts WHERE ts.empId=:empId";
			TypedQuery<TimeSheetBean> qry = entityManager.createQuery(qryString,TimeSheetBean.class);
			qry.setParameter("empId", empId);
			timeSheets = qry.getResultList();
		}catch(RuntimeException exp){
			throw new TimeSheetException(exp.getMessage());
		}
		return timeSheets;
	}
}
