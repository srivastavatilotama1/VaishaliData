package com.igate.auction.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.auction.controller.DisplayFinalCostServlet;
import com.igate.auction.dto.ItemsForBid;


//@WebFilter(filterName = "BidAuditLogFilter", urlPatterns = { "/DisplayFinalCostServlet" })


@WebFilter(filterName = "BidAuditLogFilter", 
dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE},
 urlPatterns = {"/DisplayFinalCostServlet"}, 
initParams = { @WebInitParam(name = "propFileName", value = "logger.properties") })
public class BidAuditLogFilter implements Filter 
{
	private Logger log = null;
	ServletContext ctx=null;
	String path;	
	String filename=null;		
	public void init(FilterConfig fConfig) throws ServletException 
	{		
		System.out.println(" init Audit Log Filter.........");			
		ctx = fConfig.getServletContext();
		filename = fConfig.getInitParameter("propFileName");		
	}
	

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		 System.out.println("in do filter..............................................");
		 path = ctx.getRealPath("/WEB-INF/" + filename);		 
		 PropertyConfigurator.configure(path);
		 log = Logger.getLogger(DisplayFinalCostServlet.class);
		
		 HttpSession ses=((HttpServletRequest)request).getSession();
		String unm=(String)ses.getAttribute("UserName");		
		ArrayList<ItemsForBid> myBidItemList=(ArrayList)ses.getAttribute("MyBidItemList");
		Date currDate=new Date();
		log=Logger.getLogger(DisplayFinalCostServlet.class);
		log.info(currDate+ " : "+unm +
				" : "+myBidItemList);
		chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println(" destroy Audit Log Filter.........");
	}
	

}
