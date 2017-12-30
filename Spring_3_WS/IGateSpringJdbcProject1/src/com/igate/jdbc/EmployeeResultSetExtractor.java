package com.igate.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

		public class EmployeeResultSetExtractor  implements ResultSetExtractor 
		{

		@Override
		public Object extractData(ResultSet rs) throws SQLException {
				Employee e = new Employee();
				e.setEid(rs.getInt(1));
				e.setEnm(rs.getString(2));
				e.setEsl(rs.getDouble(3));
				return e;
			
		}

	}


