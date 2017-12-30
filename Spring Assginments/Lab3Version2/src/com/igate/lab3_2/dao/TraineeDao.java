package com.igate.lab3_2.dao;

import java.util.List;

import com.igate.lab3_2.dto.Login;
import com.igate.lab3_2.dto.TraineeDetails;
import com.igate.lab3_2.exception.TraineeException;

public interface TraineeDao {

	boolean validateLogin(Login login);

	boolean insertTrainee(TraineeDetails tDetails) throws TraineeException;

	List<TraineeDetails> getAllTrainees();

	boolean updateTrainee(TraineeDetails tDetails);

	boolean deleteTrainee(int traineeId);

	List<String> getDomain();

}
