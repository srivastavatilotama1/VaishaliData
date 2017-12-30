package com.igate.tcc.service;

import java.util.List;

import com.igate.tcc.bean.PatientBean;
import com.igate.tcc.exception.PatientException;

public interface IPatientService
{
	int addPatientDetails(PatientBean patient);
	public List<PatientBean> searchPatientDetails(String patientId) throws PatientException;
	public boolean isValid(PatientBean patientDetailsObj) throws PatientException;
}
