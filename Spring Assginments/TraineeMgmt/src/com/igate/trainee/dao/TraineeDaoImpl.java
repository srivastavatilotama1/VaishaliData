package com.igate.trainee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.igate.trainee.beans.Login;
import com.igate.trainee.beans.Trainee;
import com.igate.trainee.exception.TraineeException;
import com.igate.trainee.mappers.LoginMappers;
import com.igate.trainee.mappers.TraineeMappers;

@Repository
public class TraineeDaoImpl implements TraineeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public boolean validateUser(Login login) {
		boolean isValidUser=false;
		
		String username=login.getUsername();
		String password=login.getPassword();
		
    	String selectSql="SELECT * FROM cg_user WHERE username=? and password=?";
    	Object[] params=new Object[]{username,password};
    	LoginMappers mapper=new LoginMappers();
		if(jdbcTemplate.queryForObject(selectSql,mapper,params) != null)
			isValidUser=true;
		return isValidUser;
	}


	public boolean addTrainee(Trainee trainee) throws TraineeException{
		boolean isInserted=false;
    	int traineeId=trainee.getTraineeId();
    	String traineeName=trainee.getTraineeName();
    	String traineeLocation=trainee.getTraineeLocation();
    	String traineeDomain=trainee.getTraineeDomain();
    	
    	try
    	{
    	String insertSql="INSERT INTO trainees VALUES(?,?,?,?)";
    	Object[] params=new Object[]{traineeId,traineeName,traineeLocation,traineeDomain};
    	
    	if(jdbcTemplate.update(insertSql,params)>0)	
    		isInserted=true;
    	}catch(DuplicateKeyException dk)
    	{
    		isInserted=false;
    	}
    	return isInserted;
	}


	public boolean isValidTraineeId(int traineeId)throws TraineeException {
		boolean status=false;
		System.out.println("traineeId="+traineeId);
		try
    	{
    	String sql="SELECT 1 FROM trainees WHERE traineeId=?";
		Object[] params=new Object[]{traineeId};
		int iStatus= jdbcTemplate.update(sql,params);
		if(iStatus>0)
		{
			status=true;
		}
    	}catch(EmptyResultDataAccessException eda)
		{
    		status=false;
		}
		return status;
	}


	public Trainee getTraineeDetails(int traineeId) {
		String sql="SELECT traineeId,traineeName,traineeLocation,traineeDomain FROM trainees WHERE traineeId=?";
	    Object[] params=new Object[]{traineeId};
	    TraineeMappers mapper=new TraineeMappers();
		Trainee traineeDetail=(Trainee)jdbcTemplate.queryForObject(sql,mapper,params);
	    return traineeDetail;
	}


	public boolean deleteTrainee(int traineeId) {
		boolean isDeleted=false;
    	
    	String deleteSql="DELETE FROM trainees WHERE traineeId=?";
    	Object[] params=new Object[]{traineeId};
    	
    	if(jdbcTemplate.update(deleteSql,params)>0)	
    		isDeleted=true;
    	
    	return isDeleted;
	}

	public boolean updateTrainee(Trainee trainee) {
		boolean isUpdated=false;
		int traineeId=trainee.getTraineeId();
		String traineeName=trainee.getTraineeName();
		String traineeLocation=trainee.getTraineeLocation();
		String traineeDomain=trainee.getTraineeDomain();
    	
    	String updateSql="UPDATE trainees SET traineeId=?,traineeName=?,traineeLocation=?,traineeDomain=? WHERE traineeId=?";
    	Object[] params=new Object[]{traineeId,traineeName,traineeLocation,traineeDomain,traineeId};
    	
    	
    	if(jdbcTemplate.update(updateSql,params)>0)	
    		isUpdated=true;
    	
    	return isUpdated;
	}
	
	
	
	public List<Trainee> getAllTrainees() {
		String sql="SELECT * FROM trainees";
		  TraineeMappers mapper=new TraineeMappers();
		  List<Trainee> list=jdbcTemplate.query(sql,mapper);
		  return list;
	}
	
	public List<String> getDomain()
	{
		String sql="SELECT distinct domain FROM traineedomains";
		return jdbcTemplate.queryForList(sql,String.class);
	}
}
