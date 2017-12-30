package com.cg.elms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.elms.dao.ILmsDao;
import com.cg.elms.entities.EmployeeDetails;
import com.cg.elms.entities.EmployeeLeaveDetails;

@Service
public class LmsServiceImpl implements ILmsService {

	@Autowired
	ILmsDao dao;
	
	@Override
	public EmployeeDetails getEmployeeDetails(int empId) {
		return dao.getEmployeeDetails(empId);
	}

	@Override
	public List<EmployeeLeaveDetails> getLeaveDetails(int empId) {
		return dao.getLeaveDetails(empId);
	}

}
