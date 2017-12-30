package com.igate.lab3_2.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class TraineeDetails {
	@NotEmpty(message="Please Enter Trainee Name")
	@Pattern(regexp = "^[0-9]{4}$", message = "Trainee Id must contain 4 numbers")
	private String traineeId;
	@NotEmpty(message="Please Enter Trainee Name")
	@Pattern(regexp = "^[a-zA-Z\\s]{4,20}$", message = "Trainee name must contain only alphabets")
	private String traineeName;
	@NotEmpty(message="Please Enter Trainee Location")
	private String traineeLocation;
	@NotEmpty(message="Please Enter Trainee Domain")
	private String traineeDomain;
	public String getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
}
