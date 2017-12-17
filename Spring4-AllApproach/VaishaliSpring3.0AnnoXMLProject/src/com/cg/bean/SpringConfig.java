package com.cg.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig
{	
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


}
