package com.igate.DemoMVC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.igate.DemoMVC.bean.LoginBean;
import com.igate.DemoMVC.exception.UserException;


public class LogindaoImpl implements Logindao {

	@Override
	public boolean isUserPresent(LoginBean user) throws UserException {
		boolean flag=false;
		try {
			Connection conn=new DBConnection().getConnection();
			System.out.println("in dao  connection con........"+conn);
			PreparedStatement pstat=conn.prepareStatement("select uname,password from vaishali_user where uname=? and password=?");
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			ResultSet rs=pstat.executeQuery();
			String uname=null;
			String pass=null;
			while(rs.next())
			{
				uname = rs.getString(1);
				pass = rs.getString(2);
				System.out.println(" In dao............While ..........."+uname +" : "+pass);

				if(uname.equalsIgnoreCase(user.getUsername()))
				{

					System.out.println(" In dao uname true................");
					if(pass.equalsIgnoreCase(user.getPassword()))
					{
						System.out.println(" In dao pass true................");
						flag=true;
						break;
					}
				}
				else
				{
					flag=false;
				}
			}

		}	
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
		catch (UserException e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
		return flag;
	}

}
