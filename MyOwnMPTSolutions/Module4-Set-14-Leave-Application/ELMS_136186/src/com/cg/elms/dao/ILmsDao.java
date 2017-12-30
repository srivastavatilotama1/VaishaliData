package com.cg.elms.dao;

import java.util.List;

import com.cg.elms.entities.EmployeeDetails;
import com.cg.elms.entities.EmployeeLeaveDetails;

public interface ILmsDao {
	
	public abstract EmployeeDetails getEmployeeDetails(int empId);
	
	public abstract List<EmployeeLeaveDetails> getLeaveDetails(int empId);
	
}
