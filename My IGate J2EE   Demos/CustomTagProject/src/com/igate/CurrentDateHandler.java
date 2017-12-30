package com.igate;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrentDateHandler  extends TagSupport
{
	public int doStartTag() throws JspTagException
	{
		JspWriter out=pageContext.getOut();
		Date today=new Date();
		try 
		{
			out.write(" <font color='blue'>Today Is :</font>"+
					today);
		}
		catch (IOException e)
		{			
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag()throws JspTagException
	{
		JspWriter out=pageContext.getOut();
		try 
		{
			out.write(" Vaishali In End Tag  This is System Date");
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		}
		return SKIP_PAGE;
		
	}


}
