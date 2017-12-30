package com.cg.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.timesheet.bean.TimeSheetBean;
import com.cg.timesheet.dao.ITimeSheetDao;
import com.cg.timesheet.exception.TimeSheetException;

@Service
public class TimeSheetServiceImpl implements ITimeSheetService {
	
	@Autowired
	private ITimeSheetDao dao;
	
	public ITimeSheetDao getDao() {
		return dao;
	}

	public void setDao(ITimeSheetDao dao) {
		this.dao = dao;
	}

	@Override
	public int addTiemSheet(TimeSheetBean timeSheet) throws TimeSheetException {
		return dao.addTiemSheet(timeSheet);
	}

	@Override
	public List<TimeSheetBean> getRelatedTimeSheets(String empId)
			throws TimeSheetException {
		return dao.getRelatedTimeSheets(empId);
	}

}
