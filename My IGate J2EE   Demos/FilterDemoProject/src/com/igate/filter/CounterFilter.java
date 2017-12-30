package com.igate.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CounterFilter implements Filter 
{
	FilterConfig config=null;
	Integer count;
    public CounterFilter()
    {
       System.out.println(" CounterFilter Instantiated");
    }
    public void init(FilterConfig fConfig) 
	throws ServletException 
	{
    	this.config=fConfig;
		 System.out.println(" Init  Of Counter Filter  Excecuted");		
	}

	public void destroy()
	{
		 System.out.println(" Destroy Of Counter Filter  Excecuted");		
	}
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
	throws IOException, ServletException 
	{	
		System.out.println(" Do Filter Method is excecuted");
		ServletContext ctx=config.getServletContext();
		
		count=(Integer)ctx.getAttribute("MyCount");
		if(count==null)
		{
			count=new Integer(1);
			ctx.setAttribute("MyCount", count);
			System.out.println(" True Of Filer Excecuted");
		}
		else
		{
			count=new Integer(count.intValue()+1);
			ctx.setAttribute("MyCount", count);
			System.out.println(" Else Of Filer Excecuted");
		}
		
		chain.doFilter(request, response);
	}
	
}
