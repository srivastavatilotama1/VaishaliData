package com.cg.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.aop.bean.Instrument;
import com.cg.aop.bean.Performer;

public class TestAOPClient {

	public static void main(String[] args) {
		ApplicationContext ctx=new 
				ClassPathXmlApplicationContext("aopanno.xml");
		Performer obj=(Performer)ctx.getBean("zakirHusein");
		obj.perform();
	}

}
