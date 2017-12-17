package com.cg.bean;

import java.util.ArrayList;

public class CityList
{
	private  ArrayList<City> cityList;

	@Override
	public String toString() {
		return "CityList [cityList=" + cityList + "]";
	}

	public ArrayList<City> getCityList() {
		return cityList;
	}

	public void setCityList(ArrayList<City> cityList) {
		this.cityList = cityList;
	}
	

}
