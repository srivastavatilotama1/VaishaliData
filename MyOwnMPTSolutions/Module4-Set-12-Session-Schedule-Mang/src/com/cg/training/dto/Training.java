package com.cg.training.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity

public class Training implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer tId;
	@NotEmpty(message="Name should not empty")
	private String tName;
	@NotNull
	private Integer tDuration;
	@NotEmpty(message="Faculty Name should not empty")
	private String tFaculty;
	
	private String tMode;
	
	public String gettFaculty() {
		return tFaculty;
	}
	public void settFaculty(String tFaculty) {
		this.tFaculty = tFaculty;
	}

	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Integer gettDuration() {
		return tDuration;
	}
	public void settDuration(Integer tDuration) {
		this.tDuration = tDuration;
	}
	public String gettMode() {
		return tMode;
	}
	public void settMode(String tMode) {
		this.tMode = tMode;
	}
	
}
