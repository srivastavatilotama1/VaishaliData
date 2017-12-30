package com.igate.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VehicleService 
{
	static ApplicationContext context;
	static
	{
		context=new ClassPathXmlApplicationContext("bean.xml");
	}
	public  static Vehicle getVehicle(int passengerCount)
	{
		if(passengerCount<=4)
		{
			return context.getBean("car",Vehicle.class);
		}
		else
		{
			return context.getBean("bus",Vehicle.class);
		}
	}

}
