package com.cg.bean;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
@Component
public class CustomDateEditorRegistrar implements
PropertyEditorRegistrar 
{
   
	@Override
	public void registerCustomEditors(
			PropertyEditorRegistry registry) 
	{
		 registry.registerCustomEditor(
				 Date.class, 
	               new CustomDateEditor(
	            		new SimpleDateFormat("dd-MM-yyyy"),
	            		false));
		
	}
}
