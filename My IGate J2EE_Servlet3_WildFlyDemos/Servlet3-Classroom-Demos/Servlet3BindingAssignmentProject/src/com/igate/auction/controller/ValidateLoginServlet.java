package com.igate.auction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.auction.dao.UserDaoImpl;
import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.dto.LoginDTO;
@WebServlet("/ValidateLoginServlet")
public class ValidateLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   	ServletConfig config;
	public ValidateLoginServlet()
	{
		super();        
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In Init method of ValidateLoginServlet Controller");
	}
	public void destroy()
	{
		System.out.println("In Destroy method of ValidateLoginServlet  Controller");
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
		PrintWriter out=response.getWriter();		
		HttpSession session=request.getSession(true);
		String unm=(String)session.getAttribute("UserName");
		ArrayList<ItemsForBid> bidItemList=(ArrayList)session.
				getAttribute("ItemBidList");
		System.out.println("In validate servlet  servlet ...."+bidItemList);
		
		Iterator<ItemsForBid> bidItemListIt=bidItemList.iterator();
	
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
		  	    
		  	       out.println("<th>");
			     	 out.println("STATUS");
	  	           out.println("</th>");			
				
			out.println("</tr>");			
				
		while(bidItemListIt.hasNext())
		{
			ItemsForBid ibl=bidItemListIt.next();
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
				if(ibl.getStatus().equalsIgnoreCase("Not Available"))
				{
					out.println("<td>");
					out.println(ibl.getStatus());
				}
				else
				{		
					
					out.println("<td>");
					out.println("<a href='BiddingControllerServlet?action=showMyBidItems&&bidItemId="+ibl.getItemId()+"'>"+
					ibl.getStatus()+"</a>");
					
				}				
				out.println("</td>");				
			out.println("</tr>");			
			
		}	
		out.println("</table");
		
		
	}	
}
