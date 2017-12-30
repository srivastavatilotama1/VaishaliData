package com.cg.dto;

import java.util.Date;

public class PlayerBean {
	private int playerId;
	private String playerName;
	private Date dob;
	private String country;
	private String battingStyle;
	private int centuries;
	private int matches;
	private int totalRunScore;
	private int age;
	
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBattingStyle() {
		return battingStyle;
	}
	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}
	public int getCenturies() {
		return centuries;
	}
	public void setCenturies(int centuries) {
		this.centuries = centuries;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getTotalRunScore() {
		return totalRunScore;
	}
	public void setTotalRunScore(int totalRunScore) {
		this.totalRunScore = totalRunScore;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
