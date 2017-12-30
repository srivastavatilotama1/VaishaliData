package com.igate.trainee.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.trainee.beans.Trainee;

public class TraineeMappers implements RowMapper<Trainee>{

	public Trainee mapRow(ResultSet rs, int arg1) throws SQLException {
		Trainee traineeDetails=new Trainee();
		traineeDetails.setTraineeId(rs.getInt(1));
		traineeDetails.setTraineeName(rs.getString(2));
		traineeDetails.setTraineeLocation(rs.getString(3));
		traineeDetails.setTraineeDomain(rs.getString(4));
		return traineeDetails;
	}
	
	

}
