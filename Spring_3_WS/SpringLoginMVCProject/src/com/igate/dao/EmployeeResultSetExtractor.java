package com.igate.dao;
/*
 * 
 * EMPNO
EFIRSTNAME
ELASTNAME
CITY
PREF_LANG
MARRITAL_STATUS
SALARY
DOJ
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.igate.bean.Employee;

		public class EmployeeResultSetExtractor  implements ResultSetExtractor 
		{

		@Override
		public Object extractData(ResultSet rs) throws SQLException 
		{
				
				String langArr[]=new String[1];
				langArr[0]=rs.getString("PREF_LANG");
				
				java.util.Date utilDOB=new
				java.util.Date((rs.getDate("DOJ").getTime()));
				Employee e = new Employee();
				
				e.setEid(rs.getInt("empno"));
				e.setFirstName(rs.getString("efirstname"));
				e.setLastName(rs.getString("elastname"));
				e.setCity(rs.getString("city"));
				e.setMaritalStaus(rs.getString("MARRITAL_STATUS"));
				e.setSalary(rs.getInt("salary"));
				e.setPrefLanguages(langArr);				
				e.setJoinedDate(utilDOB);
				
				System.out.println(" In Row mapper "+e);
				return e;
			
		}

	}


