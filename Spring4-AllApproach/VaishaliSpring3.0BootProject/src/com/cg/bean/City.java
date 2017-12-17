package com.cg.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("city1")
//@Component  //autowire byType
public class City
{
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Value("Pune")
	private String name;
	
	@Value("3000000")
	private int population;
	
	
	public City(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "City [name=" + name + ", population=" + population + "]";
	}
	

}
