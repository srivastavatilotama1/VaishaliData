package com.cg.bean;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.*;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages="com.cg")
public class SpringConfig
{	
	@Bean
	public City city2()
	{
		City myCity=new City("Gaziabad",500000);
		return myCity;
	}
	
	@Bean(name="city3")
	public City getCity3()
	{
		City myCity=new City("Kolkata",1000000);
		return myCity;
	}
	
	
	@Bean
	public Address homeAdd()
	{
		Address hA=new Address("UP","India","86777",new City("Gaziabad",45000));
		return hA;
	}
	
	@Bean
	public List<Address> getAddList()
	{
		City hometown=new City("Nagpur",40000);
		Address homeA=new Address("MS","INDIA","600087",hometown);


		City edutown=new City("Ramtek",20000);
		Address eduA=new Address("MS","INDIA","678",edutown);

		List<Address> addList=new ArrayList<Address>();
		addList.add(homeA);
		addList.add(eduA);

		return addList;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}


	@Bean
	public CustomEditorConfigurer customEditorConfigurer1 ()
	{
		CustomEditorConfigurer cec = new CustomEditorConfigurer();
		cec.setPropertyEditorRegistrars(
				new PropertyEditorRegistrar[]{
						new CustomDateEditorRegistrar()});

		return cec;
	}

	@Bean//(name="sqlDateObj")
	public CustomEditorConfigurer customEditorConfigurer2 ()
	{
		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = 
				new HashMap<Class<?>, Class<? extends PropertyEditor>>(1);
		customEditors.put(java.sql.Date.class, SQLDateEditor.class);

		CustomEditorConfigurer configurer = new CustomEditorConfigurer();
		configurer.setCustomEditors(customEditors);

		return configurer;
	}
}
