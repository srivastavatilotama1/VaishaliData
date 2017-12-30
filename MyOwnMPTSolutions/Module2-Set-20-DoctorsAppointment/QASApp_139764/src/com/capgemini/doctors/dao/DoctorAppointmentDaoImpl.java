package com.capgemini.doctors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exception.DoctorException;
import com.capgemini.doctors.util.DBConnection;

public class DoctorAppointmentDaoImpl implements DoctorAppointmentDao {
	Logger logger = Logger.getLogger(DoctorAppointmentDaoImpl.class);

	public DoctorAppointmentDaoImpl() {
		PropertyConfigurator.configure("resources//log4j.properties");

	}

	DoctorAppointment bean = null;

	// ------------------------ QAS Application --------------------------
	/*******************************************************************************************************
	 * - Function Name : generateAppointmentId()
	 *  - Input Parameters : - 
	 *  - ReturnType : integer
	 *  - Throws : DoctorException 
	 *  - Author : PRASEEDA 
	 *  - CreationDate : 30/11/2017
	 *  - Description : generating the Appointment ID
	 ********************************************************************************************************/

	private int generateAppointmentId() {
		int id = 0;
		Connection con = null;
		String qry = "Select seq_appointment_id.nextval from dual";
		try {
			con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(qry);
			rst.next();
			id = rst.getInt(1);
			if (id < 1000) {
				logger.error("ID not generated ");
				throw new DoctorException("unable to generate ID ");
			} else {
				logger.info("ID generated: " + id);
			}
		} catch (SQLException | DoctorException e) {
			logger.error(e);
		}
		return id;
	}

	// ------------------------ QAS Application --------------------------
	/*******************************************************************************************************
	 * - Function Name : addDoctorAppointmentDetails(DoctorAppointment bean)
	 * - Input Parameters : bean
	 * - Return Type : integer 
	 * - Throws : DoctorException 
	 * - Author : PRASEEDA 
	 * - Creation Date : 30/11/2017 
	 * - Description : Adding the patient details to database
	 ********************************************************************************************************/

	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment bean)
			throws DoctorException {
		Connection con = null;
		int appointmentId = 0;
		int queryResult = 0;
		PreparedStatement pstmt = null;
		bean.setAppointmentStatus("DISAPPROVED");
		try {
			String cmd = "Insert into doctor_appointment "
					+ "(appointment_id, patient_name,"
					+ " phone_number, date_of_appointment, email, age , "
					+ "gender, problem_name, doctor_name, appointment_status)"
					+ "values (?,?,?,(sysdate+2),?,?,?,?,?,?)";

			con = DBConnection.getConnection();
			appointmentId = generateAppointmentId();
			String problemName = bean.getProblemName();
			if (problemName.equals("Heart")) {
				bean.setDoctorName("Dr. Brijesh Kumar");
				bean.setAppointmentStatus("APPROVED");
			} else if (problemName.equals("Gynecology")) {
				bean.setDoctorName("Dr. Sharda Singh");
				bean.setAppointmentStatus("APPROVED");
			} else if (problemName.equals("Diabetes")) {
				bean.setDoctorName("Dr. Heena Khan");
				bean.setAppointmentStatus("APPROVED");
			} else if (problemName.equals("ENT")) {
				bean.setDoctorName("Dr. Paras Mal");
				bean.setAppointmentStatus("APPROVED");
			} else if (problemName.equals("Bone")) {
				bean.setDoctorName("Dr. Renuka Kher");
				bean.setAppointmentStatus("APPROVED");
			} else if (problemName.equals("Dermatology")) {
				bean.setDoctorName("Dr. Kanika Kapoor");
				bean.setAppointmentStatus("APPROVED");
			} else {
				bean.setDoctorName(null);
				bean.setAppointmentStatus("DISAPPROVED");
			}

			pstmt = con.prepareStatement(cmd);
			pstmt.setString(1, String.valueOf(appointmentId));
			pstmt.setString(2, bean.getPatientName());
			pstmt.setLong(3, bean.getPhNumber());
			pstmt.setString(4, bean.getEmailId());
			pstmt.setInt(5, bean.getPatientAge());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getProblemName());
			pstmt.setString(8, bean.getDoctorName());
			pstmt.setString(9, bean.getAppointmentStatus());
			queryResult = pstmt.executeUpdate();
			if (queryResult == 0) {
				logger.error("Insertion failed ");
				throw new DoctorException("Inserting details failed ");
			} else {
				if (bean.getAppointmentStatus().equals("APPROVED")) {
					logger.info("Registered");
					System.out
							.println("Your Doctor Appointment has been "
									+ "successfully registered, your appointment ID is :"
									+ appointmentId);
				} else {
					logger.info("not registered");
				}
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return appointmentId;
	}

	// ------------------------ QAS Application --------------------------
	/*******************************************************************************************************
	 * - Function Name : getDoctorAppointmentDetails(int appointmentId) 
	 * - Input Parameters : appointmentId 
	 * - Return Type : DoctorAppointment 
	 * - Throws : DoctorException 
	 * - Author : PRASEEDA 
	 * - Creation Date : 30/11/2017 
	 * - Description : Views the patient details based on given Appointment ID
	 ********************************************************************************************************/

	@Override
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId)
			throws DoctorException {
		bean = new DoctorAppointment();
		Connection con = null;
		PreparedStatement prepstmt = null;
		ResultSet rst = null;
		try {

			String cmd = "select patient_name,  appointment_status, "
					+ "doctor_name,  date_of_appointment "
					+ "from doctor_appointment " + "where appointment_id=?";
			con = DBConnection.getConnection();
			prepstmt = con.prepareStatement(cmd);
			prepstmt.setInt(1, appointmentId);
			rst = prepstmt.executeQuery();
			if (rst.next()) {
				bean.setPatientName(rst.getString(1));
				bean.setAppointmentStatus(rst.getString(2));
				bean.setDoctorName(rst.getString(3));
				bean.setDateOfAppointment(rst.getDate(4));
				if (bean.getAppointmentStatus().equals("DISAPPROVED")) {
					logger.info("disapproved status found");
					System.out
							.println("Appointment date and time, along with doctor's phone number will be shared shortly with you.");
				} else {
					logger.debug("your appointment details found");
				}
			} else {
				logger.error("not found");
				throw new DoctorException("Record not Found");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return bean;
	}
}
