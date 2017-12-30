package com.igate.demos;


public class Point {

	private int xCord;
	private int yCord;
	private int zCord;
	
	public Point() {
		// TODO Auto-generated constructor stub
	}
	public Point(int xCord, int yCord, int zCord) {
		super();
		this.xCord = xCord;
		this.yCord = yCord;
		this.zCord = zCord;
	}
	
	public int getxCord() {
		return xCord;
	}
	public void setxCord(int xCord) {
		this.xCord = xCord;
	}
	public int getyCord() {
		return yCord;
	}
	public void setyCord(int yCord) {
		this.yCord = yCord;
	}
	public int getzCord() {
		return zCord;
	}
	public void setzCord(int zCord) {
		this.zCord = zCord;
	}
	
	
}
