package com.cg.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class NewYearWishGreetImpl 
implements IGreet,BeanNameAware ,BeanFactoryAware ,
DisposableBean ,InitializingBean
{
	
	@Value("Vaishali")
	String name;
	
	@Value("1999")
	
	String year;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
		System.out.println("********setYear() called and year initialized***");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("********setName() called and name initialized***");
	}
	public NewYearWishGreetImpl()
	{
		System.out.println("****NewYearWishGreetImpl  Bean Instantiated*** ");
	}
	@Override
	public String greetMe()
	{		
		return name +" Happy New Year  "+year;
	}

	@Override
	public void setBeanFactory(BeanFactory bf)
			throws BeansException {
		System.out.println("setBeanFactory  callled *****");
		
	}

	@Override
	public void setBeanName(String bn) {
		System.out.println("setBeanName  callled *****"+bn);
		
	}
	public void initGreetAfterCreation()
	{
		System.out.println(" **After bean instantiated "+
	"some initialization can be performed to get it to a usable state "+ 
 "  that time initGreetAfterCreation is called************");
	}
	public void destroyGreetBeforeDeletion()
	{
		System.out.println(" **When the bean is removed from"+
	" the container, some cleanup may be required"+ 
 "  that time destroyGreetBeforeDeletion is called************");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("bean is destroied from container******");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" This Is called After  All PropertiesSet ");
		
	}
	
	

}
