package com.igate.trainee.service;

import java.util.List;

import com.igate.trainee.beans.Login;
import com.igate.trainee.beans.Trainee;
import com.igate.trainee.exception.TraineeException;

public interface TraineeService {

	public boolean validateUser(Login login);

	public boolean addTrainee(Trainee trainee) throws TraineeException;

	public boolean isValidTraineeId(int traineeId) throws TraineeException;

	public Trainee getTraineeDetails(int traineeId);

	public boolean deleteTrainee(int traineeId);

	public List<Trainee> getAllTrainees();

	public boolean updateTrainee(Trainee trainee);

	public List<String> getDomain();
	
	

}
