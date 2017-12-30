package com.igate.bean;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DateEditor  extends PropertyEditorSupport
{

	@Override
	public void setAsText(String text) throws IllegalArgumentException 
	{
		if(text.equals("today"))
		{
			setValue(new Date());
		}
		
	}
}
