package com.igate.bfpp;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class UserClient {

	public static void main(String args[]) throws Exception {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("user.xml");
		//User user = (User) ctx.getBean("user");
		//System.out.println(user.getUsername());
		
		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("user.xml"));
		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
		cfg.setLocation(new FileSystemResource("user.properties"));
		cfg.postProcessBeanFactory(factory);
		User user = (User) factory.getBean("user");
		System.out.println(user.getUsername());			
	}
}
