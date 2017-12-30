package com.capgemini.doctors.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.DoctorAppointmentDao;
import com.capgemini.doctors.dao.DoctorAppointmentDaoImpl;
import com.capgemini.doctors.exception.DoctorException;

public class DoctorAppointmentServiceImpl implements DoctorAppointmentService {

	private DoctorAppointmentDao doctorDao = new DoctorAppointmentDaoImpl();

	// Overrides the addDoctorAppointmentDetails() method of
	// DoctorAppointmentService interface
	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment bean)
			throws DoctorException {
		int appointmentId = doctorDao.addDoctorAppointmentDetails(bean);
		return appointmentId;
	}

	// Overrides the addDoctorAppointmentDetails() method of
	// DoctorAppointmentService interface
	@Override
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId)
			throws DoctorException {
		DoctorAppointment bean = doctorDao
				.getDoctorAppointmentDetails(appointmentId);
		return bean;
	}

	// Validates the Patient Name and Problem Name
	public boolean isValidName(String patientName) {
		Pattern namePattern = Pattern.compile("^[A-Z]{1}[a-z]{3,}$");
		Matcher nameMatcher = namePattern.matcher(patientName);
		return nameMatcher.matches();
	}

	// Validates the Patient Phone Number
	public boolean isValidPhNumber(long phNumber) {
		Pattern numberPattern = Pattern.compile("[7-8-9]{1}[0-9]{9}");
		Matcher numberMatcher = numberPattern.matcher(String.valueOf(phNumber));
		return numberMatcher.matches();
	}

	// Validates the Patient Email Id
	public boolean isValidEmail(String Mail) {
		Pattern mailPattern = Pattern
				.compile("[(a-z0-9\\._)]+@[(a-z)]+\\.[(a-z)]+");
		Matcher mailMatcher = mailPattern.matcher(Mail);
		return mailMatcher.matches();
	}

	// Validates the Patient Age
	public boolean isValidAge(int age) {
		Pattern agePattern = Pattern.compile("[0-9]{2}");
		Matcher ageMatcher = agePattern.matcher(String.valueOf(age));
		return ageMatcher.matches();
	}

	// Validates the Patient Gender
	public boolean isValidGender(String gender) {
		if (gender.equals("Female")) {
			return true;
		} else if (gender.equals("female")) {
			return true;
		} else if (gender.equals("male")) {
			return true;
		} else if (gender.equals("Male")) {
			return true;
		} else {
			return false;
		}

	}

	// Validates the Patient Appointment ID
	public boolean isValidAppointmentId(String appointmentId) {
		Pattern appointmentIdPattern = Pattern.compile("[1-9][0-9]{3,}");
		Matcher appointmentIdMatcher = appointmentIdPattern.matcher(String
				.valueOf(appointmentId));
		return appointmentIdMatcher.matches();
	}
}
