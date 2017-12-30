package com.igate.lab3_2.dao;

import java.sql.ResultSet;
import java.util.List;

/*import javax.annotation.PostConstruct;
import javax.sql.DataSource;*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.*;

import com.igate.lab3_2.dto.Login;
import com.igate.lab3_2.dto.TraineeDetails;
import com.igate.lab3_2.exception.TraineeException;


@Repository("traineeDao")
public class TraineeDaoImpl implements TraineeDao {
	
	/*@Autowired
	private DataSource dataSource;
	@PostConstruct
	private void initialize() {
	setDataSource(dataSource);
	}*/
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	RowMapper<TraineeDetails> rowMapper=(x,y)->{
		ResultSet rs=x;
		//int Line=y;
		TraineeDetails trainee = new TraineeDetails();
		trainee.setTraineeId(Integer.toString(rs.getInt(1)));
		trainee.setTraineeName(rs.getString(2));
		trainee.setTraineeLocation(rs.getString(3));
		trainee.setTraineeDomain(rs.getString(4));
		return trainee;
	};
	
	@Override
	public boolean validateLogin(Login login) {
		String sql="Select count(*) from cg_user where username=? and password=?";
		Object[] args= new Object[]{login.getUsername(),login.getPassword()};
		int row=jdbcTemplate.queryForObject(sql, Integer.class, args);
		if(row>0){
		return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean insertTrainee(TraineeDetails tDetails) throws TraineeException {
		String sql="Insert into trainees values(?,?,?,?)";
		boolean flag=validateTraineeId(Integer.parseInt(tDetails.getTraineeId()));
		if(flag){
		Object[] args= new Object[]{Integer.parseInt(tDetails.getTraineeId()),tDetails.getTraineeName(),
				tDetails.getTraineeLocation(),tDetails.getTraineeDomain()};
		int row=jdbcTemplate.update(sql, args);
		if(row>0){
			return true;
			}
			else{
				return false;
			}
		}
		else{
			throw new TraineeException("Trainee already exists Please Select a new Id");
		}
	}
	
	@Override
	public boolean deleteTrainee(int traineeId){
		String sql="delete trainees where traineeid=?";
		int row=jdbcTemplate.update(sql, traineeId);
		if(row>0){
			return true;
			}
			else{
				return false;
			}
	}
	
	@Override
	public boolean updateTrainee(TraineeDetails tDetails){
		String sql="update trainees set traineename=?,traineelocation=?,traineedomain=? where traineeid=?";
		Object[] args= new Object[]{tDetails.getTraineeName(),tDetails.getTraineeLocation(),
				tDetails.getTraineeDomain(),Integer.parseInt(tDetails.getTraineeId())};
		int row=jdbcTemplate.update(sql, args);
		if(row>0)
		{
			System.out.println(" In update ******************"+true);
			return true;
		}
		else
		{
				return false;
		}
	}
	
	@Override
	public List<String> getDomain(){
		String sql ="Select domain from traineedomains";
		List<String> list=jdbcTemplate.queryForList(sql,String.class);
		if(!(list.isEmpty()))
		{
		return list;
		}
		else
		{
			return null;
		}
		
	}
	
	@Override
	public List<TraineeDetails> getAllTrainees(){
		List<TraineeDetails> list = null;
		String sql="Select * from trainees";
		list=jdbcTemplate.query(sql, rowMapper);
		return list;
	}
	
	public boolean validateTraineeId(int traineeId){
		boolean flag=false;
		String sql="select traineeid from trainees where traineeid=?";
		try{
			int row=jdbcTemplate.queryForObject(sql, Integer.class,traineeId);
			if(row>0){
				flag=false;
			}
		}catch(DataAccessException dae){
			flag=true;
		}
		return flag;
	}
	
}
