package com.igate.trainee.beans;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Trainee {

	private int traineeId;
	
	@NotEmpty(message="Please Enter Trainee name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Trainee name must contain only alphabets")
	private String traineeName;
	
	@NotEmpty(message="Please select a domain")
	private String traineeDomain;
	
	@NotEmpty(message="Please select a location")
	private String traineeLocation;
	
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	
	
}
