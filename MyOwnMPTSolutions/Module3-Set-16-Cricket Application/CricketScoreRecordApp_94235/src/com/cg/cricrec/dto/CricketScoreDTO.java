package com.cg.cricrec.dto;

import java.util.Date;

public class CricketScoreDTO {
	
	private int playerId;
	private String playerName;
	private Date dob;
	private int age;
	private String team;
	private String battingstyle;
	private int  centuries;
	private int matchesplayed;
	private int totalScore;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getBattingstyle() {
		return battingstyle;
	}
	public void setBattingstyle(String battingstyle) {
		this.battingstyle = battingstyle;
	}
	public int getCenturies() {
		return centuries;
	}
	public void setCenturies(int centuries) {
		this.centuries = centuries;
	}
	public int getMatchesplayed() {
		return matchesplayed;
	}
	public void setMatchesplayed(int matchesplayed) {
		this.matchesplayed = matchesplayed;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	@Override
	public String toString() {
		return "CricketScore [playerId=" + playerId + ", playerName="
				+ playerName + ", dob=" + dob + ", team=" + team
				+ ", battingstyle=" + battingstyle + ", centuries=" + centuries
				+ ", matchesplayed=" + matchesplayed + ", totalScore="
				+ totalScore + "]";
	}
	
	
	

}
