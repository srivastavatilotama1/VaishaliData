package com.igate.yescorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.igate.yescorp.bean.FirmBean;
import com.igate.yescorp.exception.FirmException;
import com.igate.yescorp.util.DBConnection;

public class FirmRegistratiionDAOImpl implements IFirmRegisterDAO {

	@Override
	public boolean registerFirm(FirmBean firmBean) throws FirmException {
		// TODO Auto-generated method stub
		final String INSERTQUERY = "INSERT INTO FIRMS_MASTER VALUES(FirmId_Seq.NEXTVAL,?,?,?,?,'N')";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		boolean status = false;
		try {
			connection = DBConnection.getConnection();
			preparedStatement = connection.prepareStatement(INSERTQUERY);
			preparedStatement.setString(1, firmBean.getOwnerName());
			preparedStatement.setString(2, firmBean.getBusinessName());
			preparedStatement.setString(3, firmBean.getEmail());
			preparedStatement.setString(4, firmBean.getMobileNumber());
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount > 0) {
				status = true;
			}

		} catch (FirmException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FirmException("Unable To register");
		}finally{
			
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new FirmException("Problem in connection");
			}
		}
		return status;
	}

	@Override
	public void activateAccount(String emailId) throws FirmException {
		// TODO Auto-generated method stub
		final String UPDATEQUERY = "update firms_master set isactive='Y' where email=?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			connection = DBConnection.getConnection();
			preparedStatement = connection.prepareStatement(UPDATEQUERY);
			preparedStatement.setString(1, emailId);
			int count=preparedStatement.executeUpdate();
			if(count>0){
				System.out.println("updated Succesfully");
			}
		} catch (FirmException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FirmException("Unable to activate you account");
		}finally{
			
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new FirmException("Problem in connection");
			}
		}
	}

}
