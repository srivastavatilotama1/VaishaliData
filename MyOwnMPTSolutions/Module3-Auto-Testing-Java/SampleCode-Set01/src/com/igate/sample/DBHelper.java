package com.igate.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBHelper {
	
	private final static Logger logger = Logger.getLogger(DBHelper.class);
	
	public Customer addNewCustomer(Customer customer) throws SampleException {
		
		try(Connection connection = DBUtil.getConnection()) {
			logger.info("Request to add new customer started");
			String sql = "insert into customer values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			customer.setCustomerId(getNewCustomerId(connection));
			statement.setInt(1, customer.getCustomerId());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getAccountType());
			statement.setString(4, customer.getMobileNumber());
			if(statement.executeUpdate()==1) {
				logger.info("Request to add new customer completed. New assinged id:"+customer.getCustomerId());
			}
			
		} catch (SQLException | SampleException e) {
			logger.error("Problem in adding new customer. Details:"+e.toString());
			throw new SampleException("Problem in adding new customer. Details:"+e.getMessage());
		}
		return customer;
	}

	private int getNewCustomerId(Connection connection) throws SQLException {
		String sql = "select seq_cust_id.nextVal from dual";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		int newId=0;
		if(resultSet.next()) {
			newId = resultSet.getInt(1);
		}
		resultSet.close();
		statement.close();
		return newId;
	}
}
