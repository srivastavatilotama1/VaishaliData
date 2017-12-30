package com.igate.mobilerechargeservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.mobilerechargeservices.beans.Account;
import com.igate.mobilerechargeservices.exception.MobileServicesException;
import com.igate.mobilerechargeservices.util.DBConnection;

public class AccountDaoImpl implements AccountDao  {

	Connection connection = null;
	PreparedStatement pst=null;
	Account account=null;

	Logger logger=Logger.getRootLogger();
	/********************************************************************
	 *Function Name   :getAccount
	 *Input Parameters:accountId
	 *Return type     :Account
	 *Author          :Ajay Rawat
	 *Creation Date   :Oct 15, 2015
	 *Description     :This function shows the balance of the user
	 ********************************************************************/
	@Override
	public Account getAccount(String accountId) throws MobileServicesException{
		// TODO Auto-generated method stub

		final String query="SELECT * FROM ACCOUNT WHERE account_id=?";		
		try
		{
			connection=DBConnection.getDBConnection();			
			PreparedStatement preparedStatement=null;			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, accountId);
			ResultSet rs = preparedStatement.executeQuery();

			if(rs!=null)
			{	
				rs.next();				
				account=new Account();
				account.setAccountId(rs.getString("ACCOUNT_ID"));
				account.setAccountBalance(rs.getDouble("ACC_BALANCE"));		
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		finally
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new MobileServicesException("Error in closing db connection");

			}
		}
		return account;
	}



	/********************************************************************
	 *Function Name   :rechargeAccount
	 *Input Parameters:accountId, scheme
	 *Return type     :boolean
	 *Author          :Ajay Rawat
	 *Creation Date   :Oct 15, 2015
	 *Description     :This function updates Account Table for given
	 				  AccountId ,gets recharge scheme from user and updates
	 				  his balance.
	 ********************************************************************/
	@Override
	public int rechargeAccount(String accountId, double rechargeAmt)
			throws MobileServicesException {
		// TODO Auto-generated method stub
		final String updateQUERY =" Update account set ACC_BALANCE =? where ACCOUNT_ID =? ";
		int updated=0;
		
		Account originalAccDetails=getAccount(accountId);
		if (originalAccDetails!=null)
		{
			double oldBal=originalAccDetails.getAccountBalance();
			double updatedBal=oldBal-rechargeAmt;

				try{
						connection=DBConnection.getDBConnection();	
							pst=connection.prepareStatement(updateQUERY);
								pst.setDouble(1, updatedBal);
									pst.setString(2, accountId);
										updated=pst.executeUpdate();

					}
				catch(Exception e)
				{
						logger.error(e.getMessage());
							throw new MobileServicesException("SQL Error" + e.getMessage());
					}
					finally
						{
						try 
						{
								connection.close();
							} 
							catch (SQLException e) 
							{
									logger.error(e.getMessage());
										throw new MobileServicesException("Error in closing db connection");

							}
						}
		}
		return  updated;
	}
	public AccountDaoImpl() {

		PropertyConfigurator.configure("resources//log4j.properties");
	}
}
