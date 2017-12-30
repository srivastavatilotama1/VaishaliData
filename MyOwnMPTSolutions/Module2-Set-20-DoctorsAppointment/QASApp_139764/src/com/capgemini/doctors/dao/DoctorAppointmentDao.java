package com.capgemini.doctors.dao;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DoctorException;

public interface DoctorAppointmentDao {
	// Method addDoctorAppointmentDetails() declared
	public int addDoctorAppointmentDetails(DoctorAppointment bean)
			throws DoctorException;

	// Method getDoctorAppointmentDetails() declared
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId)
			throws DoctorException;

}
