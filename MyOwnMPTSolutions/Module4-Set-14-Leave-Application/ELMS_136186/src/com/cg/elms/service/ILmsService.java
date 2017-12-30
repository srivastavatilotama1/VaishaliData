package com.cg.elms.service;

import java.util.List;

import com.cg.elms.entities.EmployeeDetails;
import com.cg.elms.entities.EmployeeLeaveDetails;

public interface ILmsService {

	public abstract EmployeeDetails getEmployeeDetails(int empId);
	
	public abstract List<EmployeeLeaveDetails> getLeaveDetails(int empId);
	
}
