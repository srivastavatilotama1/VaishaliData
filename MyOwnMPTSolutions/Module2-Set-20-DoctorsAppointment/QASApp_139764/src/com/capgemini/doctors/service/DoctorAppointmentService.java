package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DoctorException;

public interface DoctorAppointmentService {
	// Method addDoctorAppointmentDetails() declared
	public int addDoctorAppointmentDetails(DoctorAppointment bean)
			throws DoctorException;

	// Method getDoctorAppointmentDetails() declared
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId)
			throws DoctorException;

}
