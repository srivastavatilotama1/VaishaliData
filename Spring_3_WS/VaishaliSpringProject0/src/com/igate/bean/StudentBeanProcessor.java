package com.igate.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class StudentBeanProcessor implements BeanPostProcessor,BeanFactoryPostProcessor
{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
	throws BeansException 
	{
		System.out.println(" ..........In postProcessBeanFactory of StudentBeanProcessor................");

	}

	@Override
	public Object postProcessAfterInitialization(Object beanObj, String beanName)
	throws BeansException 
	{
	
		System.out.println("In postProcessAfterInitialization:............ "+beanName);
		return beanObj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object beanObj, String beanName)
	throws BeansException 
	{
		System.out.println("Inn postProcessBeforeInitialization :............"+beanName);
		return beanObj;
	}


}
