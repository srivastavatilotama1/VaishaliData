package com.cg.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class NewYearWishPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, 
			String beanName)
			throws BeansException {
		System.out.println("AfterInitialization : " + beanName);
		Class cls=bean.getClass();
		String type=cls.getName();
		System.out.println(type);
	      return bean;  // you can return any other object as well
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("BeforeInitialization : " + beanName);
	      return bean;  // you can return any other object as well
	}

}
