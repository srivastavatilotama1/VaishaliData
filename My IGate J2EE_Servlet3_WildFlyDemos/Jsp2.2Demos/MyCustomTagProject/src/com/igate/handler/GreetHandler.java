package com.igate.handler;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
public class GreetHandler implements Tag
{
	private PageContext pageContext;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int doEndTag() throws JspException 
	{		
		return EVAL_PAGE;
	}
	@Override
	public int doStartTag() throws JspException 
	{	
		JspWriter out=pageContext.getOut();
		if(username!=null)
		{
			try 
			{
				out.print("<font color='green'>");
				out.print("<b>Happy New Year </b>:</font>  "+username);
			} 
			catch (IOException e)
			{			
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				out.print("<font color='green'>");
				out.print("<b>Happy New Year Everyone </b>:</font>  ");
			} 
			catch (IOException e)
			{			
				e.printStackTrace();
			}
			
		}
		return SKIP_BODY; 
	}
	@Override
	public Tag getParent() 
	{		
		return null;
	}
	@Override
	public void release()
	{	}
	@Override
	public void setPageContext(PageContext pg) 
	{
		pageContext=pg;		
	}
	@Override
	public void setParent(Tag arg0) 
	{		
	}
}
