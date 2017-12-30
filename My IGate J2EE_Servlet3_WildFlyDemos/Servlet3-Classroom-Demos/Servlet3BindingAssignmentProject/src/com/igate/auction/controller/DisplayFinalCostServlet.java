package com.igate.auction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.service.IItemsForBidService;
import com.igate.auction.service.ItemsForBidServiceImpl;

@WebServlet("/DisplayFinalCostServlet")
public class DisplayFinalCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config;
	public DisplayFinalCostServlet()
	{
		super();        
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In Init method of DisplayFinalCostServlet Controller");
	}
	public void destroy()
	{
		System.out.println("In Destroy method of DisplayFinalCostServlet  Controller");
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		doPost(request,response);
		
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException 
	{
		System.out.println(" in DisplayFinalCostServlet    ......................");
		
		PrintWriter out=response.getWriter();
				
		HttpSession session=request.getSession(true);
		
		String unm=(String)session.getAttribute("UserName");		
		ArrayList<ItemsForBid> myBidItemList=(ArrayList)session.getAttribute("MyBidItemList");
		Float finalCost =(Float)session.getAttribute("FinalCost");	
				
		Iterator<ItemsForBid> myBidItemListIt=myBidItemList.iterator();
		ItemsForBid ibl=null;
		
		out.println("<font color='green' size='20'>");
		out.println("Welcome ..........."+unm);
		out.println("</font><br/>");
		out.println("********************************************<br/>");
		out.println("<table border='1'>");		
			out.println("<tr>");
					out.println("<th>");
						out.println("ITEMID");
					out.println("</th>");
					
					out.println("<th>");
						out.println("ITEMNAME");
			  	    out.println("</th>");
			  	    
			  	    out.println("<th>");
					  out.println("ITEMPRICE");
		  	        out.println("</th>");  	  	      	
				
			out.println("</tr>");	
			
				
		while(myBidItemListIt.hasNext())
		{
			ibl=myBidItemListIt.next();
			out.println("<tr>");
				out.println("<td>");
					out.println(ibl.getItemId());
				out.println("</td>");
				
				out.println("<td>");
					out.println(ibl.getItemName());
				out.println("</td>");
			
				out.println("<td>");
						out.println(ibl.getItemPrice());
				out.println("</td>");						
			out.println("</tr>");				
		}	
		out.println("</table><br/>");			
		out.println("</font><br/>");
		out.println("Final Price Is : "+finalCost.floatValue());
		out.println("<br/>Thank You For Bidding with us<br/>");
		out.println("<a href='LoginControllerServlet?action=logOutUser'>Logout</a>");			
	}


}
