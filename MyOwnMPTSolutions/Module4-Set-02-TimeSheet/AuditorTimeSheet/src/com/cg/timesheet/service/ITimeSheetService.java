package com.cg.timesheet.service;

import java.util.List;

import com.cg.timesheet.bean.TimeSheetBean;
import com.cg.timesheet.exception.TimeSheetException;

public interface ITimeSheetService {
	int addTiemSheet(TimeSheetBean timeSheet) throws TimeSheetException;
	List<TimeSheetBean> getRelatedTimeSheets(String empId) throws TimeSheetException; 
}
