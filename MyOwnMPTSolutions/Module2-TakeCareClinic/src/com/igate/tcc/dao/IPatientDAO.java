package com.igate.tcc.dao;

import java.util.List;

import com.igate.tcc.bean.PatientBean;
import com.igate.tcc.exception.PatientException;

public interface IPatientDAO
{
	public int addPatientDetails(PatientBean patient);
	public List<PatientBean> searchPatientDetails(String patientId) throws PatientException;
}
