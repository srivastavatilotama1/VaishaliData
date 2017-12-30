package com.igate.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.tcc.bean.PatientBean;
import com.igate.tcc.exception.PatientException;
import com.igate.tcc.util.DBConnection;

public class PatientDAO implements IPatientDAO {

	Logger logger=Logger.getRootLogger();
	public PatientDAO()
	{
	PropertyConfigurator.configure("Resources/log4j.properties");
	
	}
	DBConnection dbobj = null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	int patient_sequence=0;
	int queryresult=0;
	
	
	//------------Method to insert details--------
	@Override
	public int addPatientDetails(PatientBean patient) 
	{
		// TODO Auto-generated method stub
		try
		{
			dbobj=DBConnection.getInstance();
			con=dbobj.getDBConnection();
			if(con==null)
			{
				System.out.println("connection is not created");
			}
			System.out.println("Connection established");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("SELECT patient_sequence.nextval FROM DUAL");
			res=pstmt.executeQuery();
		
			while(res.next())
			{
				patient_sequence = res.getInt(1);
					
			}
			pstmt=con.prepareStatement("INSERT INTO patient VALUES(?,?,?,?,?,sysdate)");
			pstmt.setInt(1,patient_sequence );
			pstmt.setString(2,patient.getPatientName());
			pstmt.setString(3,patient.getAge());
			pstmt.setString(4,patient.getPhoneNum());
			pstmt.setString(5,patient.getDescription());
			queryresult= pstmt.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
				logger.error(e.getMessage());
				System.out.println(e);
		}
		finally
		{
			if(res!=null)
			{
				try 
				{
					res.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					System.err.println("error in closing resultSet");
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					System.err.println("error in closing prepared statement");
				}
				
			}
			if(con!=null)
			{
				try {
					con.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("error in closing connection");
				}
				
			}
			
			
		}
		return patient_sequence;
	}
	
	//----------Method to search for patient details based on patient id---------
	@Override
	public List<PatientBean> searchPatientDetails(String patientId) throws PatientException 
	{
		// TODO Auto-generated method stub
		List<PatientBean> list=new ArrayList<>();
		PatientBean patientbeanobj=new PatientBean();
		try {
			
			dbobj=DBConnection.getInstance();
			con=dbobj.getDBConnection();
			if(con==null)
			{
				System.out.println("connection is not created");
			}
			System.out.println("Connection established");
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("SELECT patient_id,patient_name,age,phone,description,consultation_date from patient where patient_id=?");
			pstmt.setString(1,patientId);
			res=pstmt.executeQuery();
			int count=0;
			while(res.next())
			{
				patientbeanobj.setPatientId(""+res.getInt(1));
				patientbeanobj.setPatientName(""+res.getString(2));
				patientbeanobj.setAge(""+res.getInt(3));
				patientbeanobj.setPhoneNum(""+res.getString(4));
				patientbeanobj.setDescription(""+res.getString(5));
				patientbeanobj.setConsultationDate(""+res.getString(6));
				list.add(patientbeanobj);
				count++;
				patientbeanobj=new PatientBean();
			}
			if(count==0)
			{
				logger.info("no record found");
				throw new PatientException("There is no patient with this Id");
			}
		}
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			throw new PatientException("Database exception");
		}
		finally
		{
			if(res!=null)
			{
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new PatientException("error in closing resultset");
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new PatientException("error in closing prepared statement");
				}
				
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new PatientException("error in closing connection");
				}
				
			}
		
	}
	return list;
	
	}
}
