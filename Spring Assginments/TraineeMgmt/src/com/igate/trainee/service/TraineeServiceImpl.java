package com.igate.trainee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.trainee.beans.Login;
import com.igate.trainee.beans.Trainee;
import com.igate.trainee.dao.TraineeDao;
import com.igate.trainee.exception.TraineeException;

@Service
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	TraineeDao traineeDao;

	public boolean validateUser(Login login) {
		return traineeDao.validateUser(login);
	}

	public boolean addTrainee(Trainee trainee) throws TraineeException {
		return traineeDao.addTrainee(trainee);
	}

	public boolean isValidTraineeId(int traineeId) throws TraineeException {
		return traineeDao.isValidTraineeId(traineeId);
	}

	public Trainee getTraineeDetails(int traineeId) {
		return traineeDao.getTraineeDetails(traineeId);
	}

	public boolean deleteTrainee(int traineeId) {
		return traineeDao.deleteTrainee(traineeId);
	}
	
	public boolean updateTrainee(Trainee trainee) {
		return traineeDao.updateTrainee(trainee);
	}
	
	public List<Trainee> getAllTrainees() {
		return traineeDao.getAllTrainees();
	}

	public List<String> getDomain() {
		return traineeDao.getDomain();
	}

}
