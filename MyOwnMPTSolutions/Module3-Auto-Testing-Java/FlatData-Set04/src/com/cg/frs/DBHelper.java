package com.cg.frs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBHelper {
	static Logger dbLogger= Logger.getLogger(DBHelper.class);
	
	public static Connection getConnection() 
			throws FlatException{
		Connection conn=null;
		try {
			FileInputStream fin=
					new FileInputStream("database.properties");
			Properties prop= new Properties();
			prop.load(fin);
			dbLogger.info("Property file loaded..");
			System.out.println("properties loaded..");
			String driver= prop.getProperty("driver");
			String url= prop.getProperty("url");
			String user= prop.getProperty("username");
			String passwd= prop.getProperty("password");
			
			Class.forName(driver);
			System.out.println("driver loaded...");
			conn=DriverManager.getConnection(url,user,passwd);
			System.out.println("connected to db..");
			dbLogger.info("database connected...");
			return conn;
			
		} catch (SQLException e) {
			dbLogger.error(e.getMessage());
			e.printStackTrace();
			throw new FlatException(e.getMessage());
		} catch (FileNotFoundException e) {
			dbLogger.error(e.getMessage());
			e.printStackTrace();
		throw new FlatException(e.getMessage());
		} catch (IOException e) {
			dbLogger.error(e.getMessage());
			e.printStackTrace();
			throw new FlatException(e.getMessage());
		} catch (ClassNotFoundException e) {
			dbLogger.error(e.getMessage());
			e.printStackTrace();
				throw new FlatException(e.getMessage());
		}
}
	
public long insertFlat(Flat acc) 
		throws FlatException{
		try {
			Connection conn= getConnection();
		String sql= "insert into FLATS_MASTER values(Flats_seq.nextval,?,?,?,?,?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		 ps.setInt(1, acc.getFlatType());
		ps.setString(2,acc.Ownername(acc.getFirstName(),acc.getLastName()));
	    ps.setLong(3,acc.getMobileNo());
	   
	    ps.setDouble(4, acc.getRentAmt());
	    ps.setDouble(5, acc.getDepositAmt());
	    int rec=ps.executeUpdate();
	    
	    
	    if(rec==1){
	    	 sql= "select Flats_seq.currval from dual";
	    	 ps= conn.prepareStatement(sql);
	    	 ResultSet rs= ps.executeQuery();
	    	 if(rs.next())
	    	 {
	    		 long FlatId= rs.getLong(1);
	    		 dbLogger.info("record inserted :" +FlatId);
	    		 return FlatId;
	    	 }
	    }
	    
		} catch (SQLException e) {
			dbLogger.error(e.getMessage());
			e.printStackTrace();
			throw new FlatException(e.getMessage());
		}
		return 0;
	}

}


