package com.igate.lab3_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.igate.lab3_2.dao.*;
import com.igate.lab3_2.dto.Login;
import com.igate.lab3_2.dto.TraineeDetails;
import com.igate.lab3_2.exception.TraineeException;


@Component("traineeService")
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	TraineeDaoImpl dao;
	
	public TraineeDaoImpl getDao() {
		return dao;
	}

	public void setDao(TraineeDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public boolean validateLogin(Login login) {
		// TODO Auto-generated method stub
		return dao.validateLogin(login);
	}
	
	@Override
	public boolean insertTrainee(TraineeDetails tDetails) throws TraineeException {
		// TODO Auto-generated method stub
		return dao.insertTrainee(tDetails);
	}

	@Override
	public List<TraineeDetails> getAllTrainees() {
		// TODO Auto-generated method stub
		return dao.getAllTrainees();
	}

	@Override
	public boolean updateTrainee(TraineeDetails tDetails) {
		// TODO Auto-generated method stub
		return dao.updateTrainee(tDetails);
	}

	@Override
	public boolean deleteTrainee(int traineeId) {
		// TODO Auto-generated method stub
		return dao.deleteTrainee(traineeId);
	}

}
