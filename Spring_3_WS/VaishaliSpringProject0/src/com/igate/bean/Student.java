package com.igate.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Student  implements InitializingBean,
BeanNameAware,BeanFactoryAware

{
	String name;
	int roll;

	public void initStudent()
	{
		System.out.println(" Student custom  init method ");
	}
	public Student(int roll)
	{
		super();
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}

	public Student()
	{
		super();
		
	}

	@Override
	public void setBeanName(String beanName)
	{
		System.out.println(" In Student setBeanName after populating the properties "+
				beanName);		
	}

	@Override
	public void setBeanFactory(BeanFactory beanInstance) throws BeansException 
	{
		System.out.println(" In Student setBeanFactory after setBeanName" +
				"  "+				beanInstance);		
		
	}
	@Override
	public void afterPropertiesSet() throws Exception 
	{
		System.out.println(" In Student After all prop set ");
		
	}

}
