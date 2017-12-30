package com.capgemini.dao.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.doctors.exception.DoctorException;
import com.capgemini.doctors.util.DBConnection;

public class TestConnection {

	@Ignore
	@Test
	public void testConnection() throws DoctorException {
		Connection con = DBConnection.getConnection();
		assertNotNull(con);
	}

	@Test(expected = DoctorException.class)
	public void testConnectionFailed() throws DoctorException {
		Connection con = DBConnection.getConnection();
	}
}
