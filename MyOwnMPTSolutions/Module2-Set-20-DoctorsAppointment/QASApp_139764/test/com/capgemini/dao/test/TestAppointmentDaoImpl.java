package com.capgemini.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.DoctorAppointmentDaoImpl;
import com.capgemini.doctors.exception.DoctorException;

public class TestAppointmentDaoImpl {
	static DoctorAppointmentDaoImpl doctorDao;
	static DoctorAppointment bean;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		doctorDao = new DoctorAppointmentDaoImpl();
		bean = new DoctorAppointment();
	}

	@Test
	public void testAddEmployeeDetails() throws DoctorException {
		assertNotNull(doctorDao.addDoctorAppointmentDetails(bean));
	}

	@Ignore
	@Test
	public void testAddEmployeeDetails1() throws DoctorException {

		bean.setPatientName("Kanika");
		bean.setPhNumber(9876543452l);
		bean.setEmailId("kanikaSetia6@gmail.com");
		bean.setPatientAge(23);
		bean.setGender("Female");
		bean.setProblemName("Heart");
		doctorDao.addDoctorAppointmentDetails(bean);
		assertTrue("Data not Inserted",
				doctorDao.addDoctorAppointmentDetails(bean) > 1000);
	}

	@Ignore
	@Test
	public void testViewEmployee() throws DoctorException {
		assertNotNull(doctorDao.getDoctorAppointmentDetails(1007));
	}

	@Ignore
	@Test
	public void testViewEmployee1() throws DoctorException {
		assertNotNull(doctorDao.getDoctorAppointmentDetails(1010));
	}

	@Test
	public void testViewEmployee2() throws DoctorException {
		assertEquals("Not Matched", "Himanshu", doctorDao
				.getDoctorAppointmentDetails(1007).getPatientName());
	}
	
}
