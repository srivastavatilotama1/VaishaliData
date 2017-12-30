package com.cg.timesheet.bean;

import java.time.LocalDate;

import javax.inject.Singleton;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Parent;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
public class TimeSheetBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty	
	@Pattern(regexp="[A-Z]{3}[0-9]{5}",message="Should be of the form 'AAA99999'")
	private String empId;
		
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate timeSheetDate;
	
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String firstHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String secondHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String thirdHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String fourthHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String fifthHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String sixthHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String seventhHourAction;
	@NotEmpty	
	@Pattern(regexp="[A-Z_]{5,15}",message="All capitals and aminimum of 5 to maximum of 15 chars")
	private String eighthHourAction;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public LocalDate getTimeSheetDate() {
		return timeSheetDate;
	}
	public void setTimeSheetDate(LocalDate tiemSheetDate) {
		this.timeSheetDate = tiemSheetDate;
	}
	public String getFirstHourAction() {
		return firstHourAction;
	}
	public void setFirstHourAction(String firstHourAction) {
		this.firstHourAction = firstHourAction;
	}
	public String getSecondHourAction() {
		return secondHourAction;
	}
	public void setSecondHourAction(String secondHourAction) {
		this.secondHourAction = secondHourAction;
	}
	public String getThirdHourAction() {
		return thirdHourAction;
	}
	public void setThirdHourAction(String thirdHourAction) {
		this.thirdHourAction = thirdHourAction;
	}
	public String getFourthHourAction() {
		return fourthHourAction;
	}
	public void setFourthHourAction(String fourthHourAction) {
		this.fourthHourAction = fourthHourAction;
	}
	public String getFifthHourAction() {
		return fifthHourAction;
	}
	public void setFifthHourAction(String fifthHourAction) {
		this.fifthHourAction = fifthHourAction;
	}
	public String getSixthHourAction() {
		return sixthHourAction;
	}
	public void setSixthHourAction(String sixthHourAction) {
		this.sixthHourAction = sixthHourAction;
	}
	public String getSeventhHourAction() {
		return seventhHourAction;
	}
	public void setSeventhHourAction(String seventhHourAction) {
		this.seventhHourAction = seventhHourAction;
	}
	public String getEighthHourAction() {
		return eighthHourAction;
	}
	public void setEighthHourAction(String eighthHourAction) {
		this.eighthHourAction = eighthHourAction;
	}
	
	
}
