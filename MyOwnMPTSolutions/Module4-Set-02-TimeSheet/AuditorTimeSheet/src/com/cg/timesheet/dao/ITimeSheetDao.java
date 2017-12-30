package com.cg.timesheet.dao;

import java.util.List;

import com.cg.timesheet.bean.TimeSheetBean;
import com.cg.timesheet.exception.TimeSheetException;

public interface ITimeSheetDao {
	int addTiemSheet(TimeSheetBean timeSheet) throws TimeSheetException;
	List<TimeSheetBean> getRelatedTimeSheets(String empId) throws TimeSheetException; 
}
